package org.vite.gateway.blockchain.protocol;

import org.vite.gateway.blockchain.model.*;

public interface BlockchainFacade {
    AddressAndMemo getNewAddress(String mappingAddress);

    AddressValidation validateAddress(String address);

    FetchTransactionsResult listTransactions(String from, String tokenId, String address);

    FetchTransactionsResult listUnconfirmedTransactions(String tokenId, String address);

    Transaction getTransaction(String Id);

    boolean isConfirm(Transaction transaction);

    TransferResult sendTransaction(Transaction transaction);
}
