package org.vite.gateway.blockchain.model;

import java.util.List;

public class FetchTransactionsResult {
    private String from;
    private String next;
    List<Transaction> transactions;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[from ");
        sb.append(from);
        sb.append(" next ");
        sb.append(next);
        sb.append("]\n");
        if (transactions != null) {
            transactions.forEach(t -> sb.append("\t" + t + "\n"));
        }

        return sb.toString();
    }
}
