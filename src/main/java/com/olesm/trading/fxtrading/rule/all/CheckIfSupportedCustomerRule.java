package com.olesm.trading.fxtrading.rule.all;

import com.olesm.trading.fxtrading.model.Trade;
import com.olesm.trading.fxtrading.rule.ValidationError;
import com.olesm.trading.fxtrading.rule.ValidationRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CheckIfSupportedCustomerRule implements ValidationRule{

    private static final List<String> customers = Arrays.asList("PLUTO1", "PLUTO2");

    @Override
    public List<ValidationError> validate(Trade trade) {
        return customers.contains(trade.getCustomer()) ? new ArrayList<>() :
                Collections.singletonList(new ValidationError("Not valid customer", trade));
    }

}