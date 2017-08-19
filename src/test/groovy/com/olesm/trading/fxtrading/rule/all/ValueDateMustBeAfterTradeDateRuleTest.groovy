package com.olesm.trading.fxtrading.rule.all

import com.olesm.trading.fxtrading.model.Trade
import spock.lang.Specification

class ValueDateMustBeAfterTradeDateRuleTest extends Specification {

    def rule = new ValueDateMustBeAfterTradeDateRule()

    def "Should correctly validate if value date is after trade date"() {
        when:
        def trade = new Trade(
                valueDate: new Date().parse('dd/MM/yyyy', valueDate),
                tradeDate: new Date().parse('dd/MM/yyyy', tradeDate)
        )

        then:
        rule.validate(trade).isEmpty() == correct

        where:
        valueDate    | tradeDate    | correct
        "02/01/2017" | "01/01/2017" | true
        "01/01/2017" | "31/12/2016" | true
        "01/01/2017" | "01/01/2017" | true
        "01/01/2017" | "02/01/2017" | false
    }

}