package com.olesm.trading.fxtrading.service

import com.olesm.trading.fxtrading.config.FxTradingApplication
import com.olesm.trading.fxtrading.model.Trade
import com.olesm.trading.fxtrading.model.TransactionType
import com.olesm.trading.fxtrading.rule.ValidationRule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = FxTradingApplication.class)
class TradeValidatorTest extends Specification {

    @Autowired
    TradeValidator tradeValidator

    ValidationRuleProvider validationRuleProvider = Mock()
    ValidationRule rule = Mock()

    def setup() {
        tradeValidator.validationRuleProvider = validationRuleProvider
    }

    def "Should correctly call ValidationRuleProvider when validating multiple trades"() {
        given:
        def trades = [new Trade(type: TransactionType.SPOT), new Trade(type: TransactionType.FORWARD)]

        when:
        tradeValidator.validate(trades)

        then:
        2 * validationRuleProvider.provideValidationRules(_) >> [rule]
        2 * rule.validate(_) >> []
    }

    def "Should correctly call ValidationRuleProvider when validating one trade"() {
        given:
        def trade = new Trade(type: TransactionType.SPOT)

        when:
        tradeValidator.validate(trade)

        then:
        1 * validationRuleProvider.provideValidationRules(_) >> [rule]
        1 * rule.validate(_) >> []
    }


}