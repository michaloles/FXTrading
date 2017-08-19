package com.olesm.trading.fxtrading.rule.options;

import com.olesm.trading.fxtrading.model.Option;
import com.olesm.trading.fxtrading.model.OptionStyle;
import com.olesm.trading.fxtrading.model.Trade;
import com.olesm.trading.fxtrading.rule.ValidationError;
import com.olesm.trading.fxtrading.rule.ValidationRule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ExerciceStartDateValidationRule implements ValidationRule{

    @Override
    public List<ValidationError> validate(Trade trade) {
        if(trade instanceof Option){
            Option option = (Option) trade;
            if (option.getStyle()== OptionStyle.AMERICAN &&
                    (!option.getExcerciseStartDate().after(option.getTradeDate()) || !option.getExcerciseStartDate().before(option.getExpiryDate()))) {
                return Collections.singletonList(new ValidationError("Exercise start date must be after trade date and before expiry date", trade));
            }
        }
        return new ArrayList<>();
    }

}