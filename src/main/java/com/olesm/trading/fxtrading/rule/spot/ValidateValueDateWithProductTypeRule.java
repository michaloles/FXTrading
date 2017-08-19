package com.olesm.trading.fxtrading.rule.spot;

import com.olesm.trading.fxtrading.model.Trade;
import com.olesm.trading.fxtrading.model.TransactionType;
import com.olesm.trading.fxtrading.rule.ValidationError;
import com.olesm.trading.fxtrading.rule.ValidationRule;
import org.joda.time.DateTime;
import org.joda.time.Days;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidateValueDateWithProductTypeRule implements ValidationRule {

    private static final int DAYS_LIMIT_FOR_VALUE_DATE = 2;

    @Override
    public List<ValidationError> validate(Trade trade) {
        if (trade.getTradeDate() == null || trade.getValueDate() == null) {
            return Collections.singletonList(new ValidationError("Value and trade dates can't be null", trade));
        }

        int daysBetween = Days.daysBetween(new DateTime(trade.getTradeDate()).toLocalDate(), new DateTime(trade.getValueDate()).toLocalDate()).getDays();

        if (trade.getType() == TransactionType.SPOT && daysBetween > DAYS_LIMIT_FOR_VALUE_DATE) {
            return Collections.singletonList(new ValidationError("For spot transaction value date must be maximum 2 days after trade date (T+2)", trade));
        } else if (trade.getType() == TransactionType.FORWARD && daysBetween <= DAYS_LIMIT_FOR_VALUE_DATE) {
            return Collections.singletonList(new ValidationError("For forward transaction value date must at minimum 3 days after trade date", trade));
        } else {
            return new ArrayList<>();
        }
    }

}