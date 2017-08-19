package com.olesm.trading.fxtrading.rule.all;

import com.olesm.trading.fxtrading.model.Trade;
import com.olesm.trading.fxtrading.rule.ValidationError;
import com.olesm.trading.fxtrading.rule.ValidationRule;

import java.util.*;

public class CurrencyMustComplyWithISO4217Rule implements ValidationRule {

    private static final int CURRENCY_SYMBOL_LENGTH = 3;

    @Override
    public List<ValidationError> validate(Trade trade) {
        try {
            Currency.getInstance(trade.getCcyPair().substring(0, CURRENCY_SYMBOL_LENGTH));
            Currency.getInstance(trade.getCcyPair().substring(CURRENCY_SYMBOL_LENGTH));
        } catch (Exception ex) {
            return Collections.singletonList(new ValidationError("Currency pair must be valid with ISO 4217 (for example EURUSD)", trade));
        }
        return new ArrayList<>();
    }

}