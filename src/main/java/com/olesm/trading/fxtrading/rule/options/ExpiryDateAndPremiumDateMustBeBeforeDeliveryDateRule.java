package com.olesm.trading.fxtrading.rule.options;

import com.olesm.trading.fxtrading.model.Option;
import com.olesm.trading.fxtrading.model.Trade;
import com.olesm.trading.fxtrading.rule.ValidationError;
import com.olesm.trading.fxtrading.rule.ValidationRule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExpiryDateAndPremiumDateMustBeBeforeDeliveryDateRule implements ValidationRule {

    @Override
    public List<ValidationError> validate(Trade trade) {
        if(trade instanceof Option){
            Option option = (Option) trade;
            if (!option.getExpiryDate().before(option.getDeliveryDate()) && !option.getPremiumDate().before(option.getDeliveryDate())) {
                return Collections.singletonList(new ValidationError("Expiry date and premium date shall be before delivery date", trade));
            }
        }
        return new ArrayList<>();
    }

}