package org.vite.gateway.blockchain.protocol.vite;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.vite.gateway.blockchain.model.*;
import org.vite.gateway.blockchain.protocol.BlockchainFacade;
import org.vite.gateway.model.enums.TransactionType;
import org.vite.gateway.util.NumberUtil;
import org.vitej.core.protocol.HttpService;
import org.vitej.core.protocol.Vitej;
import org.vitej.core.protocol.methods.Address;
import org.vitej.core.protocol.methods.Hash;
import org.vitej.core.protocol.methods.TokenId;
import org.vitej.core.protocol.methods.enums.EBlockType;
import org.vitej.core.protocol.methods.request.Request;
import org.vitej.core.protocol.methods.request.TransactionParams;
import org.vitej.core.protocol.methods.response.*;
import org.vitej.core.wallet.Wallet;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@Component
public class ViteFacade implements BlockchainFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(ViteFacade.class);
    private final BlockingQueue<Request<?, EmptyResponse>> sendQueue = new LinkedBlockingQueue<>();
    private final ExecutorService sendingPool = Executors.newFixedThreadPool(1);

    @Value("${vite.tokenId}")
    private String TOKEN;
    @Value("${vite.confirmations}")
    private long CONFIRMATION_THRESHOLD;
    @Value("${vite.rpcUrl}")
    private String rpcUrl;
    @Value("${vite.mnemonics}")
    private List<String> mnemonics;

    private Wallet wallet;
    private Vitej vitej;
    private final Map<String, TokenInfo> tokenInfos = new ConcurrentHashMap<>();
    private Hash previousHash;
    private Long previousHeight;

    @PostConstruct
    private void init() {
        wallet = new Wallet(mnemonics);
        vitej = new Vitej(new HttpService(rpcUrl), wallet.deriveKeyPair());
        LOGGER.info("Initializing Vite Facade, RPC endpoint: {}, Confirmations: {}, Vite Address: {}, Token: {}", rpcUrl, CONFIRMATION_THRESHOLD, wallet.deriveKeyPair().getAddress(), TOKEN);

        sendingPool.execute(() -> {
            while (true) {
                sendViteTransaction();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public AddressAndMemo getNewAddress(String viteAddress) {
        return new AddressAndMemo(viteAddress, null);
    }

    @Override
    public AddressValidation validateAddress(String address) {
        return Address.isValid(address) ? AddressValidation.createValid() : AddressValidation.createInvalid("");
    }

    @Override
    public FetchTransactionsResult listTransactions(String from, String tokenId, String address) {
        FetchTransactionsResult result = new FetchTransactionsResult();
        result.setFrom(from);
        try {
            long height = 1;
            if (from != null) {
                height = Long.valueOf(from) + 1;
            }
            AccountBlockResponse accountBlockResponse = vitej.getAccountBlockByHeight(new Address(address), height).send();
            LOGGER.debug("Fetch Vite transactions from {}, address: {}, token: {}: {}", height, address, tokenId, JSON.toJSONString(accountBlockResponse));
            AccountBlock block = accountBlockResponse.getResult();

            if (block != null && block.getTokenIdRaw().equals(tokenId)) {
                Transaction transaction = mapTransaction(block);
                List<Transaction> transactions = Arrays.asList(transaction);
                result.setTransactions(transactions);
                result.setNext("" + height);
            } else {
                result.setNext(from);
            }
        } catch (IOException e) {
            e.printStackTrace();
            result.setNext(from);
        }
        return result;
    }

    @Override
    public FetchTransactionsResult listUnconfirmedTransactions(String tokenId, String address) {
        FetchTransactionsResult result = new FetchTransactionsResult();
        try {
            AccountBlocksResponse accountBlocksResponse = vitej.getUnreceivedBlocksByAddress(new Address(address), 0, 10).send();

            List<Transaction> transactions = accountBlocksResponse.getResult()
                    .stream()
                    .filter(accountBlock -> tokenId == null || accountBlock.getTokenIdRaw().equals(tokenId))
                    .map(block -> {
                        Transaction transaction = mapTransaction(block);
                        // set transaction type to 'INCOME'
                        transaction.setTransactionType(TransactionType.INCOME);
                        return transaction;
                    })
                    .collect(Collectors.toList());

            result.setTransactions(transactions);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Transaction getTransaction(String id) {
        return mapTransaction(fetchViteTransaction(id));
    }

    @Override
    public boolean isConfirm(Transaction transaction) {
        long confirmations;
        if (transaction == null) {
            return false;
        }
        // find the receive block to check if the 'transfer' is confirmed
        String receiveHash = transaction.getReferenceHash();
        if (receiveHash == null) {
            return false;
        }
        AccountBlock receiveBlock = fetchViteTransaction(receiveHash);
        if (receiveBlock == null || receiveBlock.getConfirmations() == 0) {
            return false;
        }
        confirmations = receiveBlock.getConfirmations();

        return confirmations >= CONFIRMATION_THRESHOLD;
    }

    @Override
    public TransferResult sendTransaction(Transaction transaction) {
        String token = transaction.getToken();
        int decimals = getDecimal(token);
        try {
            BigInteger viteAmount = NumberUtil.toViteAmount(transaction.getAmount(), decimals);
            TokenId tokenId = new TokenId(token);

            TransactionParams params = new TransactionParams()
                    .setBlockType(EBlockType.SEND_CALL.getValue())
                    .setToAddress(new Address(transaction.getToAddress()))
                    .setAmount(viteAmount)
                    .setTokenId(tokenId);
            if (transaction.getMemo() != null) {
                params = params.setData(transaction.getMemo().getBytes());
            }

            // set previous hash
            if (previousHash != null) {
                params.setPreviousHash(previousHash);
            }
            // set height
            if (previousHeight != null) {
                params.setHeight(previousHeight + 1);
            }

            Request<?, EmptyResponse> request = vitej.selfSendTransaction(params, false);

            String hash = addPendingRequest(request);
            if (hash != null) {
                transaction.setHash(hash);
                return TransferResult.success(transaction);
            } else {
                return TransferResult.error("Vite facade internal error: sendQueue offer failed.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return TransferResult.error(e.getMessage());
        }
    }

    @Scheduled(fixedDelay = 15 * 1000)
    private void sendViteTransaction() {
        try {
            Request<?, EmptyResponse> request = sendQueue.take();
            if (request == null) {
                return;
            }
            LOGGER.info("Sending Vite transaction...");
            Hash sendBlockHash = ((TransactionParams) request.getParams().get(0)).getHashRaw();
            EmptyResponse response = request.send();

            if (response.getError() != null) {
                // fail to send
                int code = response.getError().getCode();
                String message = response.getError().getMessage();
                LOGGER.error("Fail to send Vite transaction. Error: {} - {}", code, message);
            } else {
                // successfully sent
                LOGGER.info("Vite transaction sent: {}", sendBlockHash.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Scheduled(fixedDelay = 10 * 1000)
    private void autoReceive() {
        try {
            // query unreceived transactions
            AccountBlocksResponse accountBlocksResponse = vitej.getUnreceivedBlocksByAddress(wallet.deriveKeyPair(0).getAddress(), 0, 10).send();
            accountBlocksResponse.getResult().forEach(sendBlock -> {
                try {
                    TransactionParams params = new TransactionParams()
                            .setBlockType(EBlockType.RECEIVE.getValue())
                            .setSendBlockHash(sendBlock.getHash());

                    if (previousHeight != null) {
                        params.setPreviousHash(previousHash);
                    }
                    if (previousHeight != null) {
                        params.setHeight(previousHeight + 1);
                    }

                    Request<?, EmptyResponse> request = vitej.selfSendTransaction(params, false);

                    // add receive request into queue
                    String receiveHash = addPendingRequest(request);
                    LOGGER.info("Auto receive transaction {} -> {}", sendBlock.getHashRaw(), receiveHash);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String addPendingRequest(Request<?, EmptyResponse> request) {
        TransactionParams params = ((TransactionParams) request.getParams().get(0));
        Hash hash = params.getHashRaw();
        Long height = params.getHeightRaw();

        // put the request into the queue for later sending
        boolean result = sendQueue.offer(request);

        if (result) {
            previousHash = hash;
            previousHeight = height;
            return hash.toString();
        } else {
            LOGGER.error("Vite facade internal error: sendQueue offer failed.");
            return null;
        }
    }

    private int getDecimal(String token) {
        TokenId tokenId = new TokenId(token);
        if (!tokenInfos.containsKey(token)) {
            try {
                tokenInfos.put(token, vitej.getTokenInfoById(tokenId).send().getResult());
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }
        }
        TokenInfo info = tokenInfos.get(token);
        int decimals = info.getDecimals();
        return decimals;
    }

    private AccountBlock fetchViteTransaction(String hash) {
        if (hash == null) {
            return null;
        }
        try {
            AccountBlockResponse response = vitej.getAccountBlockByHash(new Hash(hash)).send();
            return response.getResult();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Transaction mapTransaction(AccountBlock accountBlock) {
        if (accountBlock == null) {
            return null;
        }
        String token = accountBlock.getTokenIdRaw();
        int decimals = getDecimal(token);
        Transaction transaction = new Transaction();
        transaction.setBlockchain("vite");
        transaction.setToken(token);
        transaction.setBlockHash(accountBlock.getHashRaw());
        BigInteger viteAmount = accountBlock.getAmount();
        transaction.setAmount(NumberUtil.fromViteAmount(viteAmount, decimals));
        transaction.setFromAddress(accountBlock.getFromAddressRaw());
        transaction.setToAddress(accountBlock.getToAddressRaw());
        transaction.setFee(accountBlock.getFeeRaw());
        transaction.setTimestamp(accountBlock.getTimestampRaw() * 1000);

        Integer blockType = accountBlock.getBlockType();
        transaction.setTransactionType(mapTransactionType(blockType));

        // ** IMPORTANT: Always use the hash of 'SEND transaction' as transaction hash **
        if (transaction.getTransactionType() == TransactionType.INCOME) {
            // As a 'receive transaction', hash is the send transaction related, reference is the hash of this transaction
            transaction.setHash(accountBlock.getSendBlockHashRaw());
            transaction.setReferenceHash(accountBlock.getHashRaw());
            // Fetch the send transaction related for the memo
            AccountBlock sendBlock = fetchViteTransaction(accountBlock.getSendBlockHashRaw());
            transaction.setMemo(sendBlock.getDataRaw());

        } else {
            // As a 'send transaction', reference is the receive transaction related
            transaction.setHash(accountBlock.getHashRaw());
            transaction.setReferenceHash(accountBlock.getReceiveBlockHashRaw());
            transaction.setMemo(accountBlock.getDataRaw());
        }

        long confirmations = accountBlock.getConfirmations() == null ? 0 : accountBlock.getConfirmations().longValue();
        transaction.setConfirmations(confirmations);

        return transaction;
    }

    private static TransactionType mapTransactionType(Integer viteBlockType) {
        if (viteBlockType == EBlockType.RECEIVE.getValue() || viteBlockType == EBlockType.RECEIVE_GENESIS.getValue()) {
            return TransactionType.INCOME;
        } else if (viteBlockType == EBlockType.SEND_CALL.getValue()) {
            return TransactionType.EXPENSE;
        } else {
            return TransactionType.UNKNOWN;
        }
    }
}
