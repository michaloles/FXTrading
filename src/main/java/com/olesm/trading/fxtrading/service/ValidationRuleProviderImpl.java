package com.olesm.trading.fxtrading.service;

import com.olesm.trading.fxtrading.model.Trade;
import com.olesm.trading.fxtrading.model.TransactionType;
import com.olesm.trading.fxtrading.rule.ValidationRule;
import com.olesm.trading.fxtrading.rule.all.*;
import com.olesm.trading.fxtrading.rule.options.ExerciceStartDateValidationRule;
import com.olesm.trading.fxtrading.rule.options.ExpiryDateAndPremiumDateMustBeBeforeDeliveryDateRule;
import com.olesm.trading.fxtrading.rule.spot.ValidateValueDateWithProductTypeRule;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ValidationRuleProviderImpl implements ValidationRuleProvider {

    private static final List<ValidationRule> rulesForOptionTrades = Arrays.asList(
            new CheckIfSupportedCustomerRule(),
            new CurrencyMustComplyWithISO4217Rule(),
            new LegalEntityValidationRule(),
            new ValueDateMustBeAfterTradeDateRule(),
            new ValueDateMustBeNonWorkingDayRule(),

            new ExerciceStartDateValidationRule(),
            new ExpiryDateAndPremiumDateMustBeBeforeDeliveryDateRule()
    );

    private static final List<ValidationRule> rulesForSpotAndForwardTrades = Arrays.asList(
            new CheckIfSupportedCustomerRule(),
            new CurrencyMustComplyWithISO4217Rule(),
            new LegalEntityValidationRule(),
            new ValueDateMustBeAfterTradeDateRule(),
            new ValueDateMustBeNonWorkingDayRule(),

            new ValidateValueDateWithProductTypeRule()
    );

    @Override
    public List<ValidationRule> provideValidationRules(Trade trade) {
        if (trade.getType() == TransactionType.VANILLAOPTION) {
            return rulesForOptionTrades;
        } else if (trade.getType() == TransactionType.SPOT || trade.getType() == TransactionType.FORWARD) {
            return rulesForSpotAndForwardTrades;
        } else {
            throw new IllegalArgumentException("Not supported trade type!");
        }
    }
}
