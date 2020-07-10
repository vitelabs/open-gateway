package org.vite.gateway.database.po.generated;

import java.util.Date;
import org.vite.gateway.model.enums.DepositAddressState;

public class DepositAddress {
    private Long id;

    private String originBlockchain;

    private String originAddress;

    private String memo;

    private String mappingBlockchain;

    private String mappingAddress;

    private DepositAddressState state;

    private Date ctime;

    private Date utime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginBlockchain() {
        return originBlockchain;
    }

    public void setOriginBlockchain(String originBlockchain) {
        this.originBlockchain = originBlockchain == null ? null : originBlockchain.trim();
    }

    public String getOriginAddress() {
        return originAddress;
    }

    public void setOriginAddress(String originAddress) {
        this.originAddress = originAddress == null ? null : originAddress.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getMappingBlockchain() {
        return mappingBlockchain;
    }

    public void setMappingBlockchain(String mappingBlockchain) {
        this.mappingBlockchain = mappingBlockchain == null ? null : mappingBlockchain.trim();
    }

    public String getMappingAddress() {
        return mappingAddress;
    }

    public void setMappingAddress(String mappingAddress) {
        this.mappingAddress = mappingAddress == null ? null : mappingAddress.trim();
    }

    public DepositAddressState getState() {
        return state;
    }

    public void setState(DepositAddressState state) {
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
        DepositAddress other = (DepositAddress) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOriginBlockchain() == null ? other.getOriginBlockchain() == null : this.getOriginBlockchain().equals(other.getOriginBlockchain()))
            && (this.getOriginAddress() == null ? other.getOriginAddress() == null : this.getOriginAddress().equals(other.getOriginAddress()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getMappingBlockchain() == null ? other.getMappingBlockchain() == null : this.getMappingBlockchain().equals(other.getMappingBlockchain()))
            && (this.getMappingAddress() == null ? other.getMappingAddress() == null : this.getMappingAddress().equals(other.getMappingAddress()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()))
            && (this.getUtime() == null ? other.getUtime() == null : this.getUtime().equals(other.getUtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOriginBlockchain() == null) ? 0 : getOriginBlockchain().hashCode());
        result = prime * result + ((getOriginAddress() == null) ? 0 : getOriginAddress().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getMappingBlockchain() == null) ? 0 : getMappingBlockchain().hashCode());
        result = prime * result + ((getMappingAddress() == null) ? 0 : getMappingAddress().hashCode());
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
        sb.append(", originBlockchain=").append(originBlockchain);
        sb.append(", originAddress=").append(originAddress);
        sb.append(", memo=").append(memo);
        sb.append(", mappingBlockchain=").append(mappingBlockchain);
        sb.append(", mappingAddress=").append(mappingAddress);
        sb.append(", state=").append(state);
        sb.append(", ctime=").append(ctime);
        sb.append(", utime=").append(utime);
        sb.append("]");
        return sb.toString();
    }
}