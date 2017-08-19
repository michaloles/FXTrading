package com.olesm.trading.fxtrading.rule.all

import com.olesm.trading.fxtrading.model.Trade
import spock.lang.Specification

class CheckIfSupportedCustomerRuleTest extends Specification {


    def "Should correctly validate if customer is supported"() {
        when:
        def rule = new CheckIfSupportedCustomerRule()

        then:
        rule.validate(new Trade(customer: customer)).isEmpty() == correct

        where:
        customer || correct
        "PLUTO1" || true
        "PLUTO2" || true
        null     || false
        ""       || false
        "wrong"  || false
    }

}