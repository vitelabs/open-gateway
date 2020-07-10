package org.vite.gateway.database.po.generated;

import java.util.Date;
import org.vite.gateway.model.enums.DepositState;
import org.vite.gateway.model.enums.WithdrawState;

public class TokenInfo {
    private Integer id;

    private String originBlockchain;

    private String mappingBlockchain;

    private String originTokenId;

    private String mappingTokenId;

    private String tokenName;

    private DepositState depositState;

    private WithdrawState withdrawState;

    private Double minDepositAmount;

    private Double minWithdrawAmount;

    private Double maxWithdrawAmount;

    private Double withdrawFee;

    private String originPollPointer;

    private String mappingPollPointer;

    private Date originPollTime;

    private Date mappingPollTime;

    private Date ctime;

    private Date utime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginBlockchain() {
        return originBlockchain;
    }

    public void setOriginBlockchain(String originBlockchain) {
        this.originBlockchain = originBlockchain == null ? null : originBlockchain.trim();
    }

    public String getMappingBlockchain() {
        return mappingBlockchain;
    }

    public void setMappingBlockchain(String mappingBlockchain) {
        this.mappingBlockchain = mappingBlockchain == null ? null : mappingBlockchain.trim();
    }

    public String getOriginTokenId() {
        return originTokenId;
    }

    public void setOriginTokenId(String originTokenId) {
        this.originTokenId = originTokenId == null ? null : originTokenId.trim();
    }

    public String getMappingTokenId() {
        return mappingTokenId;
    }

    public void setMappingTokenId(String mappingTokenId) {
        this.mappingTokenId = mappingTokenId == null ? null : mappingTokenId.trim();
    }

    public String getTokenName() {
        return tokenName;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName == null ? null : tokenName.trim();
    }

    public DepositState getDepositState() {
        return depositState;
    }

    public void setDepositState(DepositState depositState) {
        this.depositState = depositState;
    }

    public WithdrawState getWithdrawState() {
        return withdrawState;
    }

    public void setWithdrawState(WithdrawState withdrawState) {
        this.withdrawState = withdrawState;
    }

    public Double getMinDepositAmount() {
        return minDepositAmount;
    }

    public void setMinDepositAmount(Double minDepositAmount) {
        this.minDepositAmount = minDepositAmount;
    }

    public Double getMinWithdrawAmount() {
        return minWithdrawAmount;
    }

    public void setMinWithdrawAmount(Double minWithdrawAmount) {
        this.minWithdrawAmount = minWithdrawAmount;
    }

    public Double getMaxWithdrawAmount() {
        return maxWithdrawAmount;
    }

    public void setMaxWithdrawAmount(Double maxWithdrawAmount) {
        this.maxWithdrawAmount = maxWithdrawAmount;
    }

    public Double getWithdrawFee() {
        return withdrawFee;
    }

    public void setWithdrawFee(Double withdrawFee) {
        this.withdrawFee = withdrawFee;
    }

    public String getOriginPollPointer() {
        return originPollPointer;
    }

    public void setOriginPollPointer(String originPollPointer) {
        this.originPollPointer = originPollPointer == null ? null : originPollPointer.trim();
    }

    public String getMappingPollPointer() {
        return mappingPollPointer;
    }

    public void setMappingPollPointer(String mappingPollPointer) {
        this.mappingPollPointer = mappingPollPointer == null ? null : mappingPollPointer.trim();
    }

    public Date getOriginPollTime() {
        return originPollTime;
    }

    public void setOriginPollTime(Date originPollTime) {
        this.originPollTime = originPollTime;
    }

    public Date getMappingPollTime() {
        return mappingPollTime;
    }

    public void setMappingPollTime(Date mappingPollTime) {
        this.mappingPollTime = mappingPollTime;
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
        TokenInfo other = (TokenInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOriginBlockchain() == null ? other.getOriginBlockchain() == null : this.getOriginBlockchain().equals(other.getOriginBlockchain()))
            && (this.getMappingBlockchain() == null ? other.getMappingBlockchain() == null : this.getMappingBlockchain().equals(other.getMappingBlockchain()))
            && (this.getOriginTokenId() == null ? other.getOriginTokenId() == null : this.getOriginTokenId().equals(other.getOriginTokenId()))
            && (this.getMappingTokenId() == null ? other.getMappingTokenId() == null : this.getMappingTokenId().equals(other.getMappingTokenId()))
            && (this.getTokenName() == null ? other.getTokenName() == null : this.getTokenName().equals(other.getTokenName()))
            && (this.getDepositState() == null ? other.getDepositState() == null : this.getDepositState().equals(other.getDepositState()))
            && (this.getWithdrawState() == null ? other.getWithdrawState() == null : this.getWithdrawState().equals(other.getWithdrawState()))
            && (this.getMinDepositAmount() == null ? other.getMinDepositAmount() == null : this.getMinDepositAmount().equals(other.getMinDepositAmount()))
            && (this.getMinWithdrawAmount() == null ? other.getMinWithdrawAmount() == null : this.getMinWithdrawAmount().equals(other.getMinWithdrawAmount()))
            && (this.getMaxWithdrawAmount() == null ? other.getMaxWithdrawAmount() == null : this.getMaxWithdrawAmount().equals(other.getMaxWithdrawAmount()))
            && (this.getWithdrawFee() == null ? other.getWithdrawFee() == null : this.getWithdrawFee().equals(other.getWithdrawFee()))
            && (this.getOriginPollPointer() == null ? other.getOriginPollPointer() == null : this.getOriginPollPointer().equals(other.getOriginPollPointer()))
            && (this.getMappingPollPointer() == null ? other.getMappingPollPointer() == null : this.getMappingPollPointer().equals(other.getMappingPollPointer()))
            && (this.getOriginPollTime() == null ? other.getOriginPollTime() == null : this.getOriginPollTime().equals(other.getOriginPollTime()))
            && (this.getMappingPollTime() == null ? other.getMappingPollTime() == null : this.getMappingPollTime().equals(other.getMappingPollTime()))
            && (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()))
            && (this.getUtime() == null ? other.getUtime() == null : this.getUtime().equals(other.getUtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOriginBlockchain() == null) ? 0 : getOriginBlockchain().hashCode());
        result = prime * result + ((getMappingBlockchain() == null) ? 0 : getMappingBlockchain().hashCode());
        result = prime * result + ((getOriginTokenId() == null) ? 0 : getOriginTokenId().hashCode());
        result = prime * result + ((getMappingTokenId() == null) ? 0 : getMappingTokenId().hashCode());
        result = prime * result + ((getTokenName() == null) ? 0 : getTokenName().hashCode());
        result = prime * result + ((getDepositState() == null) ? 0 : getDepositState().hashCode());
        result = prime * result + ((getWithdrawState() == null) ? 0 : getWithdrawState().hashCode());
        result = prime * result + ((getMinDepositAmount() == null) ? 0 : getMinDepositAmount().hashCode());
        result = prime * result + ((getMinWithdrawAmount() == null) ? 0 : getMinWithdrawAmount().hashCode());
        result = prime * result + ((getMaxWithdrawAmount() == null) ? 0 : getMaxWithdrawAmount().hashCode());
        result = prime * result + ((getWithdrawFee() == null) ? 0 : getWithdrawFee().hashCode());
        result = prime * result + ((getOriginPollPointer() == null) ? 0 : getOriginPollPointer().hashCode());
        result = prime * result + ((getMappingPollPointer() == null) ? 0 : getMappingPollPointer().hashCode());
        result = prime * result + ((getOriginPollTime() == null) ? 0 : getOriginPollTime().hashCode());
        result = prime * result + ((getMappingPollTime() == null) ? 0 : getMappingPollTime().hashCode());
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
        sb.append(", originBlockchain=").append(originBlockchain);
        sb.append(", mappingBlockchain=").append(mappingBlockchain);
        sb.append(", originTokenId=").append(originTokenId);
        sb.append(", mappingTokenId=").append(mappingTokenId);
        sb.append(", tokenName=").append(tokenName);
        sb.append(", depositState=").append(depositState);
        sb.append(", withdrawState=").append(withdrawState);
        sb.append(", minDepositAmount=").append(minDepositAmount);
        sb.append(", minWithdrawAmount=").append(minWithdrawAmount);
        sb.append(", maxWithdrawAmount=").append(maxWithdrawAmount);
        sb.append(", withdrawFee=").append(withdrawFee);
        sb.append(", originPollPointer=").append(originPollPointer);
        sb.append(", mappingPollPointer=").append(mappingPollPointer);
        sb.append(", originPollTime=").append(originPollTime);
        sb.append(", mappingPollTime=").append(mappingPollTime);
        sb.append(", ctime=").append(ctime);
        sb.append(", utime=").append(utime);
        sb.append("]");
        return sb.toString();
    }
}