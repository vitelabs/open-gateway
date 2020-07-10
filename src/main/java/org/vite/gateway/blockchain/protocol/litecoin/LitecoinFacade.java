package org.vite.gateway.blockchain.protocol.litecoin;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.vite.gateway.blockchain.model.*;
import org.vite.gateway.blockchain.protocol.BlockchainFacade;
import org.vite.gateway.blockchain.transport.jsonrpc.JsonRpcClient;
import org.vite.gateway.blockchain.transport.jsonrpc.RpcExcption;
import org.vite.gateway.model.enums.TransactionType;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LitecoinFacade implements BlockchainFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(LitecoinFacade.class);
    private static final String BLOCKCHAIN = "litecoin";

    @Value("${litecoin.tokenId}")
    private String TOKEN;
    @Value("${litecoin.confirmations}")
    private long CONFIRMATION_THRESHOLD;
    @Value("${litecoin.rpcUrl}")
    private String rpcUrl;
    @Value("${litecoin.rpcUser}")
    private String rpcUser;
    @Value("${litecoin.rpcPassword}")
    private String rpcPassword;

    private JsonRpcClient rpcClient;

    @PostConstruct
    private void init() {
        LOGGER.info("Initializing Litecoin Facade, RPC endpoint: {}, Confirmations: {}", rpcUrl, CONFIRMATION_THRESHOLD);
        rpcClient = new JsonRpcClient(rpcUrl, rpcUser, rpcPassword);
    }

    @Override
    public AddressAndMemo getNewAddress(String mappingAddress) {
        try {
            JSONObject result = rpcClient.call("getnewaddress");
            String ltcAddress = result.getString("result");
            LOGGER.debug("Binding LTC deposit address {} -> {} ", mappingAddress, ltcAddress);
            return new AddressAndMemo(ltcAddress, null);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public AddressValidation validateAddress(String address) {
        try {
            JSONObject result = rpcClient.call("validateaddress", Arrays.asList(address));
            boolean valid = result.getJSONObject("result").getBooleanValue("isvalid");
            if (valid) {
                return AddressValidation.createValid();
            } else {
                return AddressValidation.createInvalid("");
            }

        } catch (IOException e) {
            e.printStackTrace();
            return AddressValidation.createInvalid("RPC ERROR: " + e.getMessage());
        }
    }

    @Override
    public FetchTransactionsResult listTransactions(String from, String tokenId, String address) {
        FetchTransactionsResult result = new FetchTransactionsResult();
        result.setFrom(from);

        try {
            LOGGER.debug("fetch transactions from " + from);
            JSONObject response = rpcClient.call("listsinceblock", Arrays.asList(from));

            JSONObject data = response.getJSONObject("result");
            JSONArray txArray = data.getJSONArray("transactions");
            List<Transaction> transactions = new ArrayList<>();
            int size = txArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject tx = txArray.getJSONObject(i);
                Transaction transaction = new Transaction();
                transaction.setBlockchain(BLOCKCHAIN);
                transaction.setToken(TOKEN);
                transaction.setTransactionType(mapTransactionType(tx.getString("category")));
                transaction.setHash(tx.getString("txid"));
                transaction.setBlockHash(tx.getString("blockhash"));
                transaction.setAmount(tx.getString("amount"));
                transaction.setFee(tx.getString("fee"));
                transaction.setToAddress(tx.getString("address"));
                transaction.setConfirmations(tx.getLongValue("confirmations"));
                transaction.setMemo(tx.getString("comment"));
                transaction.setTimestamp(tx.getLongValue("time") * 1000);

                transactions.add(transaction);
            }

            result.setNext(data.getString("lastblock"));

            result.setTransactions(transactions);

            return result;

        } catch (IOException e) {
            e.printStackTrace();
            result.setNext(from);
            return result;
        }
    }

    @Override
    public FetchTransactionsResult listUnconfirmedTransactions(String tokenId, String address) {
        FetchTransactionsResult result = new FetchTransactionsResult();
        try {
            JSONObject response = rpcClient.call("getrawmempool");
            JSONArray txids = response.getJSONArray("result");
            List<Transaction> transactions = txids.stream()
                    .map(String::valueOf)
                    .map(txid -> getRawTransaction(txid))
                    .filter(list -> list != null)
                    .flatMap(list -> list.stream())
                    .collect(Collectors.toList());

            result.setTransactions(transactions);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Transaction getTransaction(String id) {
        int index = 0;
        try {
            JSONObject response = rpcClient.call("gettransaction", Arrays.asList(id, true));
            JSONObject result = response.getJSONObject("result");
            Transaction transaction = new Transaction();
            transaction.setBlockchain(BLOCKCHAIN);
            transaction.setToken(TOKEN);
            transaction.setBlockHash(result.getString("blockhash"));
            transaction.setHash(result.getString("txid"));
            transaction.setConfirmations(result.getLongValue("confirmations"));
            transaction.setTimestamp(result.getLongValue("time") * 1000);

            // handle multi-received-address in 'details' field
            JSONObject detail = result.getJSONArray("details").getJSONObject(index);
            // parse from detail
            transaction.setToAddress(detail.getString("address"));
            transaction.setAmount(detail.getBigDecimal("amount").abs().toPlainString());
            if (detail.containsKey("fee")) {
                transaction.setFee(detail.getBigDecimal("fee").abs().toPlainString());
            }
            transaction.setTransactionType(mapTransactionType(detail.getString("category")));

            return transaction;
        } catch (RpcExcption e) {
            e.printStackTrace();
            return null;
        } catch (IOException e1) {
            e1.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean isConfirm(Transaction transaction) {
        if (transaction == null) {
            return false;
        }
        long confirmation = transaction.getConfirmations();
        return confirmation >= CONFIRMATION_THRESHOLD;
    }

    @Override
    public TransferResult sendTransaction(Transaction transaction) {
        LOGGER.info("Send LTC transaction {}", transaction);

        String address = transaction.getToAddress();
        String amount = transaction.getAmount();

        try {
            JSONObject response = rpcClient.call("sendtoaddress", Arrays.asList(address, amount));
            String hash = response.getString("result");
            transaction.setHash(hash);
            return TransferResult.success(transaction);
        } catch (RpcExcption e) {
            String message = e.getData().getJSONObject("error").getString("message");
            return TransferResult.error(message);
        } catch (IOException e) {
            e.printStackTrace();
            return TransferResult.error(e.getMessage());
        }
    }

    private static TransactionType mapTransactionType(String category) {
        if ("send".equals(category)) {
            return TransactionType.EXPENSE;
        } else if ("receive".equals(category)) {
            return TransactionType.INCOME;
        } else {
            return TransactionType.UNKNOWN;
        }
    }

    private List<Transaction> getRawTransaction(String id) {
        List<Transaction> transactions = new ArrayList<>();
        try {
            JSONObject response = rpcClient.call("getrawtransaction", Arrays.asList(id, true));
            JSONObject result = response.getJSONObject("result");

            // handle outputs
            JSONArray outs = result.getJSONArray("vout");
            for (int i = 0; i < outs.size(); i++) {
                JSONObject out = outs.getJSONObject(i);
                JSONArray addresses = out.getJSONObject("scriptPubKey").getJSONArray("addresses");
                for (int j = 0; j < addresses.size(); j++) {
                    String address = addresses.getString(j);

                    Transaction transaction = new Transaction();
                    transaction.setBlockchain(BLOCKCHAIN);
                    transaction.setToken(TOKEN);
                    transaction.setHash(result.getString("txid"));
                    transaction.setConfirmations(0);
                    transaction.setToAddress(address);
                    transaction.setAmount(out.getString("value"));

                    transactions.add(transaction);
                }
            }
            return transactions;
        } catch (RpcExcption e) {
            e.printStackTrace();
            return null;
        } catch (IOException e1) {
            e1.printStackTrace();
            return null;
        }
    }
}
