package org.vite.gateway.model.enums;

public enum WithdrawRecordState {
    UNKNOWN,
    TOT_PROCESSING,
    TOT_NOT_RECEIVED,
    TOT_CONFIRMED,
    TOT_EXCEED_THE_LIMIT,
    WRONG_WITHDRAW_ADDRESS,
    OPPOSITE_PROCESSING,
    OPPOSITE_CONFIRMED,
    UNDEFINE_OPPOSITE_ERROR,
    FAILED
}
