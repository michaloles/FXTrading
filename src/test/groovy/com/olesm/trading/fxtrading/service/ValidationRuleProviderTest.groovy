package com.olesm.trading.fxtrading.service

import com.olesm.trading.fxtrading.config.FxTradingApplication
import com.olesm.trading.fxtrading.model.Trade
import com.olesm.trading.fxtrading.model.TransactionType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = FxTradingApplication.class)
class ValidationRuleProviderTest extends Specification {

    @Autowired
    ValidationRuleProvider validationRuleProvider

    def "Should provide correct rule count for each trade type"() {
        expect:
        validationRuleProvider.provideValidationRules(new Trade(type: type)).size() == expectedRuleCount

        where:
        type                          | expectedRuleCount
        TransactionType.VANILLAOPTION | 7
        TransactionType.SPOT          | 6
        TransactionType.FORWARD       | 6
    }


}