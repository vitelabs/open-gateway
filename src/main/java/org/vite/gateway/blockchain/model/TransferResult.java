package org.vite.gateway.blockchain.model;

public class TransferResult {
    private boolean success;
    private String message;
    private Transaction transaction;

    private TransferResult(Transaction transaction) {
        this.success = true;
        this.message = transaction.getHash();
        this.transaction = transaction;
    }

    private TransferResult(String message) {
        this.success = false;
        this.message = message;
    }

    public static TransferResult success(Transaction transaction) {
        return new TransferResult(transaction);
    }

    public static TransferResult error(String message) {
        return new TransferResult(message);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
