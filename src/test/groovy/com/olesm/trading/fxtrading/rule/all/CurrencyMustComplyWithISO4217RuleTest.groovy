package com.olesm.trading.fxtrading.rule.all

import com.olesm.trading.fxtrading.model.Trade
import spock.lang.Specification

class CurrencyMustComplyWithISO4217RuleTest extends Specification {


    def "Should check if currency comply with ISO 4217"() {
        when:
        def rule = new CurrencyMustComplyWithISO4217Rule()

        then:
        rule.validate(new Trade(ccyPair: ccyPair)).isEmpty() == correct

        where:
        ccyPair  || correct
        "EURUSD" || true
        "USDEUR" || true
        "PLNUSD" || true
        "USDPLN" || true
        "PLNEUR" || true
        "EURPLN" || true
        "XXXYYY" || false
        "PLN"    || false
        null     || false
        ""       || false

    }

}