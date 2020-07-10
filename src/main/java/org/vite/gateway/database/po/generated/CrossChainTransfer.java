package org.vite.gateway.database.po.generated;

import java.util.Date;
import org.vite.gateway.model.enums.CrossChainTransferState;

public class CrossChainTransfer {
    private Long id;

    private Double amount;

    private String blockchainSource;

    private String tokenIdSource;

    private String hashSource;

    private String fromAddressSource;

    private String toAddressSource;

    private String memoSource;

    private Double feeSource;

    private Long confirmationsSource;

    private Date transactionTimeSource;

    private String blockchainDest;

    private String tokenIdDest;

    private String hashDest;

    private String fromAddressDest;

    private String toAddressDest;

    private String memoDest;

    private Double feeDest;

    private Long confirmationsDest;

    private Date transactionTimeDest;

    private CrossChainTransferState state;

    private Date ctime;

    private Date utime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getBlockchainSource() {
        return blockchainSource;
    }

    public void setBlockchainSource(String blockchainSource) {
        this.blockchainSource = blockchainSource == null ? null : blockchainSource.trim();
    }

    public String getTokenIdSource() {
        return tokenIdSource;
    }

    public void setTokenIdSource(String tokenIdSource) {
        this.tokenIdSource = tokenIdSource == null ? null : tokenIdSource.trim();
    }

    public String getHashSource() {
        return hashSource;
    }

    public void setHashSource(String hashSource) {
        this.hashSource = hashSource == null ? null : hashSource.trim();
    }

    public String getFromAddressSource() {
        return fromAddressSource;
    }

    public void setFromAddressSource(String fromAddressSource) {
        this.fromAddressSource = fromAddressSource == null ? null : fromAddressSource.trim();
    }

    public String getToAddressSource() {
        return toAddressSource;
    }

    public void setToAddressSource(String toAddressSource) {
        this.toAddressSource = toAddressSource == null ? null : toAddressSource.trim();
    }

    public String getMemoSource() {
        return memoSource;
    }

    public void setMemoSource(String memoSource) {
        this.memoSource = memoSource == null ? null : memoSource.trim();
    }

    public Double getFeeSource() {
        return feeSource;
    }

    public void setFeeSource(Double feeSource) {
        this.feeSource = feeSource;
    }

    public Long getConfirmationsSource() {
        return confirmationsSource;
    }

    public void setConfirmationsSource(Long confirmationsSource) {
        this.confirmationsSource = confirmationsSource;
    }

    public Date getTransactionTimeSource() {
        return transactionTimeSource;
    }

    public void setTransactionTimeSource(Date transactionTimeSource) {
        this.transactionTimeSource = transactionTimeSource;
    }

    public String getBlockchainDest() {
        return blockchainDest;
    }

    public void setBlockchainDest(String blockchainDest) {
        this.blockchainDest = blockchainDest == null ? null : blockchainDest.trim();
    }

    public String getTokenIdDest() {
        return tokenIdDest;
    }

    public void setTokenIdDest(String tokenIdDest) {
        this.tokenIdDest = tokenIdDest == null ? null : tokenIdDest.trim();
    }

    public String getHashDest() {
        return hashDest;
    }

    public void setHashDest(String hashDest) {
        this.hashDest = hashDest == null ? null : hashDest.trim();
    }

    public String getFromAddressDest() {
        return fromAddressDest;
    }

    public void setFromAddressDest(String fromAddressDest) {
        this.fromAddressDest = fromAddressDest == null ? null : fromAddressDest.trim();
    }

    public String getToAddressDest() {
        return toAddressDest;
    }

    public void setToAddressDest(String toAddressDest) {
        this.toAddressDest = toAddressDest == null ? null : toAddressDest.trim();
    }

    public String getMemoDest() {
        return memoDest;
    }

    public void setMemoDest(String memoDest) {
        this.memoDest = memoDest == null ? null : memoDest.trim();
    }

    public Double getFeeDest() {
        return feeDest;
    }

    public void setFeeDest(Double feeDest) {
        this.feeDest = feeDest;
    }

    public Long getConfirmationsDest() {
        return confirmationsDest;
    }

    public void setConfirmationsDest(Long confirmationsDest) {
        this.confirmationsDest = confirmationsDest;
    }

    public Date getTransactionTimeDest() {
        return transactionTimeDest;
    }

    public void setTransactionTimeDest(Date transactionTimeDest) {
        this.transactionTimeDest = transactionTimeDest;
    }

    public CrossChainTransferState getState() {
        return state;
    }

    public void setState(CrossChainTransferState state) {
        this.state = state;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CrossChainTransfer other = (CrossChainTransfer) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getBlockchainSource() == null ? other.getBlockchainSource() == null : this.getBlockchainSource().equals(other.getBlockchainSource()))
            && (this.getTokenIdSource() == null ? other.getTokenIdSource() == null : this.getTokenIdSource().equals(other.getTokenIdSource()))
            && (this.getHashSource() == null ? other.getHashSource() == null : this.getHashSource().equals(other.getHashSource()))
            && (this.getFromAddressSource() == null ? other.getFromAddressSource() == null : this.getFromAddressSource().equals(other.getFromAddressSource()))
            && (this.getToAddressSource() == null ? other.getToAddressSource() == null : this.getToAddressSource().equals(other.getToAddressSource()))
            && (this.getMemoSource() == null ? other.getMemoSource() == null : this.getMemoSource().equals(other.getMemoSource()))
            && (this.getFeeSource() == null ? other.getFeeSource() == null : this.getFeeSource().equals(other.getFeeSource()))
            && (this.getConfirmationsSource() == null ? other.getConfirmationsSource() == null : this.getConfirmationsSource().equals(other.getConfirmationsSource()))
            && (this.getTransactionTimeSource() == null ? other.getTransactionTimeSource() == null : this.getTransactionTimeSource().equals(other.getTransactionTimeSource()))
            && (this.getBlockchainDest() == null ? other.getBlockchainDest() == null : this.getBlockchainDest().equals(other.getBlockchainDest()))
            && (this.getTokenIdDest() == null ? other.getTokenIdDest() == null : this.getTokenIdDest().equals(other.getTokenIdDest()))
            && (this.getHashDest() == null ? other.getHashDest() == null : this.getHashDest().equals(other.getHashDest()))
            && (this.getFromAddressDest() == null ? other.getFromAddressDest() == null : this.getFromAddressDest().equals(other.getFromAddressDest()))
            && (this.getToAddressDest() == null ? other.getToAddressDest() == null : this.getToAddressDest().equals(other.getToAddressDest()))
            && (this.getMemoDest() == null ? other.getMemoDest() == null : this.getMemoDest().equals(other.getMemoDest()))
            && (this.getFeeDest() == null ? other.getFeeDest() == null : this.getFeeDest().equals(other.getFeeDest()))
            && (this.getConfirmationsDest() == null ? other.getConfirmationsDest() == null : this.getConfirmationsDest().equals(other.getConfirmationsDest()))
            && (this.getTransactionTimeDest() == null ? other.getTransactionTimeDest() == null : this.getTransactionTimeDest().equals(other.getTransactionTimeDest()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()))
            && (this.getUtime() == null ? other.getUtime() == null : this.getUtime().equals(other.getUtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getBlockchainSource() == null) ? 0 : getBlockchainSource().hashCode());
        result = prime * result + ((getTokenIdSource() == null) ? 0 : getTokenIdSource().hashCode());
        result = prime * result + ((getHashSource() == null) ? 0 : getHashSource().hashCode());
        result = prime * result + ((getFromAddressSource() == null) ? 0 : getFromAddressSource().hashCode());
        result = prime * result + ((getToAddressSource() == null) ? 0 : getToAddressSource().hashCode());
        result = prime * result + ((getMemoSource() == null) ? 0 : getMemoSource().hashCode());
        result = prime * result + ((getFeeSource() == null) ? 0 : getFeeSource().hashCode());
        result = prime * result + ((getConfirmationsSource() == null) ? 0 : getConfirmationsSource().hashCode());
        result = prime * result + ((getTransactionTimeSource() == null) ? 0 : getTransactionTimeSource().hashCode());
        result = prime * result + ((getBlockchainDest() == null) ? 0 : getBlockchainDest().hashCode());
        result = prime * result + ((getTokenIdDest() == null) ? 0 : getTokenIdDest().hashCode());
        result = prime * result + ((getHashDest() == null) ? 0 : getHashDest().hashCode());
        result = prime * result + ((getFromAddressDest() == null) ? 0 : getFromAddressDest().hashCode());
        result = prime * result + ((getToAddressDest() == null) ? 0 : getToAddressDest().hashCode());
        result = prime * result + ((getMemoDest() == null) ? 0 : getMemoDest().hashCode());
        result = prime * result + ((getFeeDest() == null) ? 0 : getFeeDest().hashCode());
        result = prime * result + ((getConfirmationsDest() == null) ? 0 : getConfirmationsDest().hashCode());
        result = prime * result + ((getTransactionTimeDest() == null) ? 0 : getTransactionTimeDest().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
        result = prime * result + ((getUtime() == null) ? 0 : getUtime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", amount=").append(amount);
        sb.append(", blockchainSource=").append(blockchainSource);
        sb.append(", tokenIdSource=").append(tokenIdSource);
        sb.append(", hashSource=").append(hashSource);
        sb.append(", fromAddressSource=").append(fromAddressSource);
        sb.append(", toAddressSource=").append(toAddressSource);
        sb.append(", memoSource=").append(memoSource);
        sb.append(", feeSource=").append(feeSource);
        sb.append(", confirmationsSource=").append(confirmationsSource);
        sb.append(", transactionTimeSource=").append(transactionTimeSource);
        sb.append(", blockchainDest=").append(blockchainDest);
        sb.append(", tokenIdDest=").append(tokenIdDest);
        sb.append(", hashDest=").append(hashDest);
        sb.append(", fromAddressDest=").append(fromAddressDest);
        sb.append(", toAddressDest=").append(toAddressDest);
        sb.append(", memoDest=").append(memoDest);
        sb.append(", feeDest=").append(feeDest);
        sb.append(", confirmationsDest=").append(confirmationsDest);
        sb.append(", transactionTimeDest=").append(transactionTimeDest);
        sb.append(", state=").append(state);
        sb.append(", ctime=").append(ctime);
        sb.append(", utime=").append(utime);
        sb.append("]");
        return sb.toString();
    }
}