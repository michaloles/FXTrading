package com.olesm.trading.fxtrading.rule.all;

import com.olesm.trading.fxtrading.model.Trade;
import com.olesm.trading.fxtrading.rule.ValidationError;
import com.olesm.trading.fxtrading.rule.ValidationRule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValueDateMustBeAfterTradeDateRule implements ValidationRule {

    @Override
    public List<ValidationError> validate(Trade trade) {
        if (trade.getValueDate()!=null && trade.getValueDate().before(trade.getTradeDate())) {
            return Collections.singletonList(new ValidationError("Value date cannot be before trade date", trade));
        } else {
            return new ArrayList<>();
        }
    }

}