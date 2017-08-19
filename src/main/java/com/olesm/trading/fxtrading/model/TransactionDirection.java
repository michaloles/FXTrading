package com.olesm.trading.fxtrading.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TransactionDirection {

    SELL, BUY;

    @JsonCreator
    public static TransactionDirection fromString(String key) {
        return key == null ? null : TransactionDirection.valueOf(key.toUpperCase());
    }

}