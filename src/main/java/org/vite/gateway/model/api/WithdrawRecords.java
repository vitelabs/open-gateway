package org.vite.gateway.model.api;

import java.util.List;

public class WithdrawRecords {
    private long totalCount;
    private List<WithdrawRecordItem> withdrawRecords;
    private String inTxExplorerFormat;
    private String outTxExplorerFormat;

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public List<WithdrawRecordItem> getWithdrawRecords() {
        return withdrawRecords;
    }

    public void setWithdrawRecords(List<WithdrawRecordItem> withdrawRecords) {
        this.withdrawRecords = withdrawRecords;
    }

    public String getInTxExplorerFormat() {
        return inTxExplorerFormat;
    }

    public void setInTxExplorerFormat(String inTxExplorerFormat) {
        this.inTxExplorerFormat = inTxExplorerFormat;
    }

    public String getOutTxExplorerFormat() {
        return outTxExplorerFormat;
    }

    public void setOutTxExplorerFormat(String outTxExplorerFormat) {
        this.outTxExplorerFormat = outTxExplorerFormat;
    }

    public static class WithdrawRecordItem {
        private String inTxHash;
        private Integer inTxConfirmedCount;
        private Integer inTxConfirmationCount;
        private String outTxHash;
        private String amount;
        private String fee;
        private String state;
        private String dateTime;

        public String getInTxHash() {
            return inTxHash;
        }

        public void setInTxHash(String inTxHash) {
            this.inTxHash = inTxHash;
        }

        public Integer getInTxConfirmedCount() {
            return inTxConfirmedCount;
        }

        public void setInTxConfirmedCount(Integer inTxConfirmedCount) {
            this.inTxConfirmedCount = inTxConfirmedCount;
        }

        public Integer getInTxConfirmationCount() {
            return inTxConfirmationCount;
        }

        public void setInTxConfirmationCount(Integer inTxConfirmationCount) {
            this.inTxConfirmationCount = inTxConfirmationCount;
        }

        public String getOutTxHash() {
            return outTxHash;
        }

        public void setOutTxHash(String outTxHash) {
            this.outTxHash = outTxHash;
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

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getDateTime() {
            return dateTime;
        }

        public void setDateTime(String dateTime) {
            this.dateTime = dateTime;
        }
    }
}
