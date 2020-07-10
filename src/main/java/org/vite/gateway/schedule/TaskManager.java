package org.vite.gateway.schedule;

import com.google.common.base.Charsets;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.vite.gateway.blockchain.BlockchainDelegate;
import org.vite.gateway.blockchain.model.AddressAndMemo;
import org.vite.gateway.blockchain.model.FetchTransactionsResult;
import org.vite.gateway.blockchain.model.Transaction;
import org.vite.gateway.database.DBFacade;
import org.vite.gateway.database.po.generated.CrossChainTransfer;
import org.vite.gateway.database.po.generated.DepositAddress;
import org.vite.gateway.database.po.generated.TokenInfo;
import org.vite.gateway.model.enums.CrossChainTransferState;
import org.vite.gateway.model.enums.DepositState;
import org.vite.gateway.model.enums.TransactionType;
import org.vite.gateway.model.enums.WithdrawState;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class TaskManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskManager.class);

    @Autowired
    private BlockchainDelegate blockchainDelegate;

    @Autowired
    private DBFacade database;

    private final Map<Long, TransferTask> transferTasks = new ConcurrentHashMap<>();
    private String originBlockchain;
    private String mappingBlockchain;
    private String originTokenId;
    private String mappingTokenId;

    @PostConstruct
    private void init() {
        LOGGER.info("Init Task Manager...");
        originBlockchain = blockchainDelegate.getOriginBlockchain();
        mappingBlockchain = blockchainDelegate.getMappingBlockchain();
        originTokenId = blockchainDelegate.getOriginTokenId();
        mappingTokenId = blockchainDelegate.getMappingTokenId();

        // reload tasks
        List<CrossChainTransferState> pendingStates = Arrays.asList(CrossChainTransferState.SOURCE_TRANSACTION_FOUND, CrossChainTransferState.SOURCE_TRANSACTION_CONFIRMED, CrossChainTransferState.DEST_TRANSACTION_SENDING, CrossChainTransferState.DEST_TRANSACTION_SENT);
        reloadTasks(pendingStates);
    }

    @Scheduled(fixedDelay = 10 * 1000)
    private void pollDeposit() {
        TokenInfo tokenInfo = database.getTokenInfo(mappingBlockchain, mappingTokenId);

        if (tokenInfo == null || tokenInfo.getDepositState() != DepositState.OPEN) {
            return;
        }

        String next = tokenInfo.getOriginPollPointer();
        String gatewayAddress = blockchainDelegate.getDepositAddress();

        // fetch transactions with zero confirmation
        FetchTransactionsResult unconfirmed = blockchainDelegate.getOriginBlockchainFacade().listUnconfirmedTransactions(originTokenId, gatewayAddress);
        // fetch confirmed transactions
        FetchTransactionsResult confirmed = blockchainDelegate.getOriginBlockchainFacade().listTransactions(next, originTokenId, gatewayAddress);

        LOGGER.debug("Poll [{}|{}] from {}: {}\n {}", originBlockchain, originTokenId, next, unconfirmed, confirmed);

        List<Transaction> transactions = mergeTransactions(unconfirmed, confirmed);

        transactions.forEach(transaction -> {
            String address = transaction.getToAddress();
            String memo = transaction.getMemo();
            DepositAddress depositAddress = database.getDepositAddressByOriginAddress(originBlockchain, mappingBlockchain, address, memo);
            if (depositAddress != null) {
                // valid deposit
                LOGGER.info("New deposit transaction found: {}", transaction);
                String mappingAddress = depositAddress.getMappingAddress();

                // check if there's a record in database
                if (!database.containsCrossChainTransfer(originBlockchain, transaction.getHash())) {
                    // new deposit record, insert into database
                    CrossChainTransfer record = mapCrossChainTransfer(transaction);

                    record.setBlockchainDest(mappingBlockchain);
                    record.setTokenIdDest(mappingTokenId);
                    record.setToAddressDest(mappingAddress);

                    database.insertCrossChainTransfer(record);
                }
            }
        });

        next = confirmed.getNext();
        tokenInfo.setOriginPollPointer(next);
        tokenInfo.setOriginPollTime(new Date());
        database.updateTokenInfo(tokenInfo);
    }

    @Scheduled(fixedDelay = 10 * 1000)
    private void pollWithdraw() {
        TokenInfo tokenInfo = database.getTokenInfo(mappingBlockchain, mappingTokenId);

        if (tokenInfo == null || tokenInfo.getWithdrawState() != WithdrawState.OPEN) {
            return;
        }

        String next = tokenInfo.getMappingPollPointer();
        String withdrawAddress = blockchainDelegate.getWithdrawAddress();

        // fetch transactions with zero confirmation
        FetchTransactionsResult unconfirmed = blockchainDelegate.getMappingBlockchainFacade().listUnconfirmedTransactions(originTokenId, withdrawAddress);
        // fetch confirmed transactions
        FetchTransactionsResult confirmed = blockchainDelegate.getMappingBlockchainFacade().listTransactions(next, mappingTokenId, withdrawAddress);

        LOGGER.debug("Poll [{}|{}] from {}: {}\n {}", originBlockchain, originTokenId, next, unconfirmed, confirmed);

        List<Transaction> transactions = mergeTransactions(unconfirmed, confirmed);

        transactions.forEach(transaction -> {
            String memo = transaction.getMemo();
            AddressAndMemo addressAndMemo = parseMemo(memo);

            if (addressAndMemo != null) {
                LOGGER.info("New withdraw transaction found: {}", transaction);

                // check if there's a record in database
                if (!database.containsCrossChainTransfer(mappingBlockchain, transaction.getHash())) {
                    // new withdraw record, insert into database
                    CrossChainTransfer record = mapCrossChainTransfer(transaction);

                    record.setBlockchainDest(originBlockchain);
                    record.setTokenIdDest(originTokenId);
                    record.setToAddressDest(addressAndMemo.getAddress());
                    record.setMemoDest(addressAndMemo.getMemo());

                    database.insertCrossChainTransfer(record);
                }
            }
        });

        next = confirmed.getNext();
        tokenInfo.setMappingPollPointer(next);
        tokenInfo.setMappingPollTime(new Date());
        database.updateTokenInfo(tokenInfo);
    }

    @Scheduled(fixedDelay = 5 * 1000)
    public void spawnTransferTask() {
        List<CrossChainTransferState> pendingStates = Arrays.asList(CrossChainTransferState.SOURCE_TRANSACTION_FOUND);
        reloadTasks(pendingStates);
    }

    private static List<Transaction> mergeTransactions(FetchTransactionsResult r1, FetchTransactionsResult r2) {
        Map<String, Transaction> map = new HashMap<>();
        if (r1 != null) {
            map.putAll(filterTransactions(r1.getTransactions()));
        }
        if (r2 != null) {
            map.putAll(filterTransactions(r2.getTransactions()));
        }
        return new ArrayList<>(map.values());
    }

    private static Map<String, Transaction> filterTransactions(List<Transaction> list) {
        Map<String, Transaction> map = new HashMap<>();
        if (list != null) {
            list.stream()
                    .filter(Objects::nonNull)
                    .filter(t -> t.getHash() != null)
                    .filter(t -> t.getTransactionType() == TransactionType.INCOME)
                    .forEach(t -> map.putIfAbsent(t.getHash(), t));
        }

        return map;
    }

    private void reloadTasks(List<CrossChainTransferState> pendingStates) {
        // reload pending deposit records from database
        List<CrossChainTransfer> pendingDeposits = database.getCrossChainTransfersInStates(originBlockchain, mappingBlockchain, pendingStates);
        if (pendingDeposits != null) {
            LOGGER.debug("Load {} pending deposits.", pendingDeposits.size());
            pendingDeposits.forEach(deposit -> {
                Long id = deposit.getId();
                if (!transferTasks.containsKey(id)) {
                    // create a new deposit task
                    LOGGER.info("Create new deposit task with {}", deposit);
                    TransferTask depositTask = TransferTask.create(database, blockchainDelegate.getOriginBlockchainFacade(), blockchainDelegate.getMappingBlockchainFacade());
                    // put it into task map
                    transferTasks.put(id, depositTask);
                    // start the task
                    depositTask.start(deposit);
                }
            });
        }

        // reload pending withdrawals from database
        List<CrossChainTransfer> pendingWithdrawals = database.getCrossChainTransfersInStates(mappingBlockchain, originBlockchain, pendingStates);
        if (pendingWithdrawals != null) {
            LOGGER.debug("Load {} pending withdrawals.", pendingWithdrawals.size());
            pendingWithdrawals.forEach(withdrawal -> {
                Long id = withdrawal.getId();
                if (!transferTasks.containsKey(id)) {
                    // create a new deposit task
                    LOGGER.info("Create new withdraw task with {}", withdrawal);
                    TransferTask withdrawTask = TransferTask.create(database, blockchainDelegate.getMappingBlockchainFacade(), blockchainDelegate.getOriginBlockchainFacade());
                    // put it into task map
                    transferTasks.put(id, withdrawTask);
                    // start the task
                    withdrawTask.start(withdrawal);
                }
            });
        }
    }

    private static CrossChainTransfer mapCrossChainTransfer(Transaction transaction) {
        CrossChainTransfer record = new CrossChainTransfer();

        record.setBlockchainSource(transaction.getBlockchain());
        record.setTokenIdSource(transaction.getToken());
        record.setHashSource(transaction.getHash());
        record.setAmount(Double.valueOf(transaction.getAmount()));
        if (transaction.getFee() != null) {
            record.setFeeSource(Double.valueOf(transaction.getFee()));
        }
        record.setConfirmationsSource(transaction.getConfirmations());
        record.setFromAddressSource(transaction.getFromAddress());
        record.setToAddressSource(transaction.getToAddress());
        record.setMemoSource(transaction.getMemo());
        record.setTransactionTimeSource(new Date(transaction.getTimestamp()));
        record.setState(CrossChainTransferState.SOURCE_TRANSACTION_FOUND);

        return record;
    }

    private static AddressAndMemo parseMemo(String data) {
        try {
            byte[] dataBytes = Base64.decodeBase64(data);
            if (dataBytes.length <= 3) {
                return null;
            }

            byte[] header = Arrays.copyOfRange(dataBytes, 0, 2);
            int i = byteArrayToInt(header);
            if (3011 != i) {
                return null;
            }

            byte[] type = Arrays.copyOfRange(dataBytes, 2, 3);
            int typeInt = byteArrayToInt(type);

            if (typeInt == 0) {
                byte[] addressBytes = Arrays.copyOfRange(dataBytes, 3, dataBytes.length);
                String address = new String(addressBytes, Charsets.UTF_8);
                return new AddressAndMemo(address, null);
            } else if (typeInt == 1) {
                int addressSize = byteArrayToInt(Arrays.copyOfRange(dataBytes, 3, 4));
                byte[] addressBytes = Arrays.copyOfRange(dataBytes, 4, 4 + addressSize);
                String address = new String(addressBytes, Charsets.UTF_8);

                int memoSize = byteArrayToInt(Arrays.copyOfRange(dataBytes, 4 + addressSize, 4 + addressSize + 1));
                byte[] memoBytes = Arrays.copyOfRange(dataBytes, 4 + addressSize + 1, 4 + addressSize + 1 + memoSize);
                String memo = new String(memoBytes, Charsets.UTF_8);
                return new AddressAndMemo(address, memo);
            } else {
                return null;
            }
        } catch (Exception e) {
            LOGGER.error("Parse memo error: {}", e.getMessage());
            return null;
        }
    }

    private static byte[] IntToByteArray(int num, int arrayLength) {
        byte[] bytes = new byte[arrayLength];

        for (int i = arrayLength, c = 0; i > 0; i--, c++) {
            bytes[c] = (byte) ((num >> 8 * (i - 1)) & 0xff);
        }
        return bytes;
    }

    private static int byteArrayToInt(byte[] bytes) {

        if (bytes.length > 4) {
            throw new IndexOutOfBoundsException();
        }

        int res = 0;
        for (int i = bytes.length - 1, c = 0; i >= 0; i--, c++) {
            res = res | (bytes[i] & 0xff) << 8 * c;
        }
        return res;
    }
}
