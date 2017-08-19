package com.olesm.trading.fxtrading.rule.all

import com.olesm.trading.fxtrading.model.Trade
import spock.lang.Specification

class LegalEntityValidationRuleTest extends Specification {


    def "Should correctly validate if legal entity is valid"() {
        when:
        def rule = new LegalEntityValidationRule()

        then:
        rule.validate(new Trade(legalEntity: legalEntity)).isEmpty() == correct

        where:
        legalEntity || correct
        "CS Zurich" || true
        "CS ZURICH" || true
        null        || false
        ""          || false
        "wrong"     || false
    }

}