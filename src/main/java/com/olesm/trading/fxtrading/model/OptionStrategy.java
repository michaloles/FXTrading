package com.olesm.trading.fxtrading.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum OptionStrategy {

    CALL;

    @JsonCreator
    public static OptionStrategy fromString(String key) {
        return key == null ? null : OptionStrategy.valueOf(key.toUpperCase());
    }

}