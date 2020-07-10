package org.vite.gateway.blockchain.model;

import org.vite.gateway.model.enums.TransactionType;

public class Transaction {
    private String blockchain;

    private String token;

    private String hash;

    private String referenceHash;

    private TransactionType transactionType;

    private String toAddress;

    private String fromAddress;

    private String memo;

    private String amount;

    private String fee;

    private String blockHash;

    private long timestamp;

    private long confirmations;

    public String getBlockchain() {
        return blockchain;
    }

    public void setBlockchain(String blockchain) {
        this.blockchain = blockchain;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getReferenceHash() {
        return referenceHash;
    }

    public void setReferenceHash(String referenceHash) {
        this.referenceHash = referenceHash;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(long confirmations) {
        this.confirmations = confirmations;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaction [");
        sb.append(blockchain);
        sb.append("|");
        sb.append(token);
        sb.append("] ");
        sb.append(transactionType);
        sb.append(" ");
        sb.append(confirmations);
        sb.append("-confirms ");
        sb.append(hash);
        if (referenceHash != null) {
            sb.append(" (");
            sb.append(referenceHash);
            sb.append(")");
        }
        sb.append(" ");
        sb.append(fromAddress);
        sb.append(" -> ");
        sb.append(toAddress);
        sb.append(" amount: ");
        sb.append(amount);
        sb.append(" fee: ");
        sb.append(fee);
        if (memo != null) {
            sb.append(" memo: ");
            sb.append(memo);
        }

        return sb.toString();
    }
}
