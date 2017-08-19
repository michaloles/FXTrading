package com.olesm.trading.fxtrading.service;

import com.olesm.trading.fxtrading.model.Trade;
import com.olesm.trading.fxtrading.rule.ValidationError;

import java.util.Collection;
import java.util.List;

public interface TradeValidator {

    List<ValidationError> validate(Trade trade);
    List<ValidationError> validate(Collection<Trade> trades);

}