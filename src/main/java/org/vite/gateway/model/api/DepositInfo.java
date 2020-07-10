package org.vite.gateway.model.api;

public class DepositInfo {
    private String depositAddress;

    private String labelName;

    private String label;

    private String minimumDepositAmount;

    private int confirmationCount;

    private String noticeMsg;

    public String getDepositAddress() {
        return depositAddress;
    }

    public void setDepositAddress(String depositAddress) {
        this.depositAddress = depositAddress;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getMinimumDepositAmount() {
        return minimumDepositAmount;
    }

    public void setMinimumDepositAmount(String minimumDepositAmount) {
        this.minimumDepositAmount = minimumDepositAmount;
    }

    public int getConfirmationCount() {
        return confirmationCount;
    }

    public void setConfirmationCount(int confirmationCount) {
        this.confirmationCount = confirmationCount;
    }

    public String getNoticeMsg() {
        return noticeMsg;
    }

    public void setNoticeMsg(String noticeMsg) {
        this.noticeMsg = noticeMsg;
    }
}
