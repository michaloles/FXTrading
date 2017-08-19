package com.olesm.trading.fxtrading.rule;

import com.olesm.trading.fxtrading.model.Trade;

import java.util.List;

public interface ValidationRule {

    List<ValidationError> validate(Trade trade);

}