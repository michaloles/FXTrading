package com.olesm.trading.fxtrading.util

import com.olesm.trading.fxtrading.config.FxTradingApplication
import com.olesm.trading.fxtrading.model.Trade
import com.olesm.trading.fxtrading.rest.TradeController
import com.olesm.trading.fxtrading.service.TradeValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = FxTradingApplication.class)
class TradeControllerTest extends Specification {

    @Autowired
    TradeController restController

    TradeValidator validator = Mock()

    def setup() {
        restController.tradeValidator = validator
    }

    def "Should autowire TradeController correctly"() {
        expect:
        restController != null
    }


    def "Should correctly call validator when validating one trade"() {
        given:
        def trade = new Trade()

        when:
        restController.validateTrade(trade)

        then:
        1 * validator.validate(trade)
    }

    def "Should correctly call validator when validating multiple trades"() {
        given:
        def trades = [new Trade(), new Trade()]

        when:
        restController.validateTrades(trades)

        then:
        1 * validator.validate(trades)
    }

}