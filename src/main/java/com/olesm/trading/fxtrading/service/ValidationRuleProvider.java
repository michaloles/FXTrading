package com.olesm.trading.fxtrading.service;

import com.olesm.trading.fxtrading.model.Trade;
import com.olesm.trading.fxtrading.rule.ValidationRule;

import java.util.List;

public interface ValidationRuleProvider {

    List<ValidationRule> provideValidationRules(Trade trade);
}
