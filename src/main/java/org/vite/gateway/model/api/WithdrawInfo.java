package org.vite.gateway.model.api;

public class WithdrawInfo {
    private String minimumWithdrawAmount;
    private String maximumWithdrawAmount;
    private String gatewayAddress;
    private String labelName;
    private String noticeMsg;

    public String getMinimumWithdrawAmount() {
        return minimumWithdrawAmount;
    }

    public void setMinimumWithdrawAmount(String minimumWithdrawAmount) {
        this.minimumWithdrawAmount = minimumWithdrawAmount;
    }

    public String getMaximumWithdrawAmount() {
        return maximumWithdrawAmount;
    }

    public void setMaximumWithdrawAmount(String maximumWithdrawAmount) {
        this.maximumWithdrawAmount = maximumWithdrawAmount;
    }

    public String getGatewayAddress() {
        return gatewayAddress;
    }

    public void setGatewayAddress(String gatewayAddress) {
        this.gatewayAddress = gatewayAddress;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getNoticeMsg() {
        return noticeMsg;
    }

    public void setNoticeMsg(String noticeMsg) {
        this.noticeMsg = noticeMsg;
    }
}
