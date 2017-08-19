package com.olesm.trading.fxtrading.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum OptionStyle {

    AMERICAN, EUROPEAN;

    @JsonCreator
    public static OptionStyle fromString(String key) {
        return key == null ? null : OptionStyle.valueOf(key.toUpperCase());
    }

}