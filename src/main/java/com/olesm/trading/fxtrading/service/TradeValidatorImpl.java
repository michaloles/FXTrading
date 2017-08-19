package com.olesm.trading.fxtrading.service;


import com.olesm.trading.fxtrading.model.Trade;
import com.olesm.trading.fxtrading.rule.ValidationError;
import com.olesm.trading.fxtrading.rule.ValidationRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class TradeValidatorImpl implements TradeValidator{

    @Autowired
    ValidationRuleProvider validationRuleProvider;

    @Override
    public List<ValidationError> validate(Trade trade) {
        List<ValidationRule> rules = validationRuleProvider.provideValidationRules(trade);
        List<ValidationError> validationErrors = new ArrayList<>();
        for(ValidationRule rule: rules){
            validationErrors.addAll(rule.validate(trade));
        }
        return validationErrors;
    }

    @Override
    public List<ValidationError> validate(Collection<Trade> trades) {
        List<ValidationError> validationErrors = new ArrayList<>();
        for(Trade trade: trades){
            validationErrors.addAll(validate(trade));
        }
        return validationErrors;
    }

}