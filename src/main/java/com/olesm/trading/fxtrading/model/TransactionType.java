package com.olesm.trading.fxtrading.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TransactionType {

    SPOT, FORWARD, VANILLAOPTION;

    @JsonCreator
    public static TransactionType fromString(String key) {
        return key == null ? null : TransactionType.valueOf(key.toUpperCase());
    }

}