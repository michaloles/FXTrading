package com.olesm.trading.fxtrading.rule;

import com.olesm.trading.fxtrading.model.Trade;
import lombok.Data;

@Data
public class ValidationError {

    private Trade errorTrade;
    private String errorMessage;

    public ValidationError(String errorMessage, Trade errorTrade) {
        this.errorMessage = errorMessage;
        this.errorTrade = errorTrade;
    }

}
