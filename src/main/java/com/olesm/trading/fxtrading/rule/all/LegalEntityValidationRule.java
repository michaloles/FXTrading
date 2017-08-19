package com.olesm.trading.fxtrading.rule.all;

import com.olesm.trading.fxtrading.model.Trade;
import com.olesm.trading.fxtrading.rule.ValidationError;
import com.olesm.trading.fxtrading.rule.ValidationRule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LegalEntityValidationRule implements ValidationRule {

    @Override
    public List<ValidationError> validate(Trade trade) {
        return trade.getLegalEntity()!= null && trade.getLegalEntity().equalsIgnoreCase("CS Zurich") ? new ArrayList<>() :
                Collections.singletonList(new ValidationError("Legal entity must be CS Zurich", trade));
    }

}