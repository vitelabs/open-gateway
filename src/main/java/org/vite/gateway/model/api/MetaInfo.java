package org.vite.gateway.model.api;

import org.vite.gateway.model.enums.DepositState;
import org.vite.gateway.model.enums.WithdrawState;

public class MetaInfo {
    private int type;
    private DepositState depositState;
    private WithdrawState withdrawState;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
}
