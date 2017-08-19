package com.olesm.trading.fxtrading.rule.all;

import com.olesm.trading.fxtrading.model.Trade;
import com.olesm.trading.fxtrading.rule.ValidationError;
import com.olesm.trading.fxtrading.rule.ValidationRule;
import com.olesm.trading.fxtrading.util.DateHelper;

import java.util.*;

public class ValueDateMustBeNonWorkingDayRule implements ValidationRule {

    @Override
    public List<ValidationError> validate(Trade trade) {
        if(trade.getValueDate()!=null && (DateHelper.isWeekend(trade.getValueDate()) || DateHelper.isHoliday(trade.getValueDate()))) {
            return Collections.singletonList(new ValidationError("Value date cannot be non working day or public holiday", trade));
        } else {
            return new ArrayList<>();
        }
    }

}