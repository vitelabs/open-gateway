package org.vite.gateway.model.enums;

public enum DepositRecordState {
    UNKNOWN,
    OPPOSITE_PROCESSING,
    OPPOSITE_FORKED,
    BELOW_MINIMUM,
    OPPOSITE_CONFIRMED_FAIL,
    OPPOSITE_CONFIRMED,
    TOT_PROCESSING,
    TOT_CONFIRMED,
    FAILED
}
