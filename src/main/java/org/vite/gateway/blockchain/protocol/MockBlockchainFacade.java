package org.vite.gateway.blockchain.protocol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.vite.gateway.blockchain.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component()
public class MockBlockchainFacade implements BlockchainFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(MockBlockchainFacade.class);
    private long blockHeight = 0;
    private final Map<String, AddressAndMemo> addresses = new HashMap<>();

    @Override
    public AddressAndMemo getNewAddress(String mappingAddress) {
        AddressAndMemo addressAndMemo = new AddressAndMemo("mock-address-" + mappingAddress, "");

        addresses.putIfAbsent(mappingAddress, addressAndMemo);
        return addressAndMemo;
    }

    @Override
    public AddressValidation validateAddress(String address) {
        return AddressValidation.createValid();
    }

    @Override
    public FetchTransactionsResult listTransactions(String from, String tokenId, String address) {
        FetchTransactionsResult result = new FetchTransactionsResult();
        result.setFrom(from);
        result.setNext(blockHeight + "");

        List<Transaction> transactions = new ArrayList<>();
        AddressAndMemo addressAndMemo = randomAddress();
        if (addressAndMemo != null) {
            Transaction transaction = new Transaction();
            transaction.setBlockchain("MOCK");
            transaction.setHash("mock-tx-" + from + "-" + blockHeight);
            transaction.setBlockHash("block-" + blockHeight);
            transaction.setAmount("100");

            transaction.setToAddress(addressAndMemo.getAddress());
            transaction.setMemo(addressAndMemo.getMemo());

            transactions.add(transaction);
        }

        result.setTransactions(transactions);

        return result;
    }

    @Override
    public FetchTransactionsResult listUnconfirmedTransactions(String tokenId, String address) {
        return null;
    }

    @Override
    public Transaction getTransaction(String id) {
        return null;
    }

    @Override
    public boolean isConfirm(Transaction transaction) {
        return false;
    }

    @Override
    public TransferResult sendTransaction(Transaction transaction) {
        LOGGER.debug("send transaction {}", transaction);
        transaction.setHash("abcde");

        return TransferResult.success(transaction);
    }

    private AddressAndMemo randomAddress() {
        if (addresses.isEmpty())
            return null;
        Object[] a = addresses.values().toArray();
        int i = (int) (Math.random() * a.length);
        return (AddressAndMemo) a[i];
    }

    public static void main(String[] args) {
        System.out.println("Test mock blockchain");
        MockBlockchainFacade facade = new MockBlockchainFacade();

        System.out.println("New Address is " + facade.getNewAddress("vite_1"));

        System.out.println("Fetch transactions \n" + facade.listTransactions("0", null, null));

    }
}
