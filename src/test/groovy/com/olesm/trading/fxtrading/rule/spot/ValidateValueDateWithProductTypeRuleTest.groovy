package com.olesm.trading.fxtrading.rule.spot

import com.olesm.trading.fxtrading.model.Trade
import com.olesm.trading.fxtrading.model.TransactionType
import spock.lang.Specification

class ValidateValueDateWithProductTypeRuleTest extends Specification {

    def rule = new ValidateValueDateWithProductTypeRule()

    def "Should correctly validate value date according to transaction type"() {
        when:
        def trade = new Trade(
                type: type,
                valueDate: new Date().parse('dd/MM/yyyy', valueDate),
                tradeDate: new Date().parse('dd/MM/yyyy', tradeDate)
        )

        then:
        rule.validate(trade).isEmpty() == correct

        where:
        type                    | tradeDate    | valueDate    | correct
        TransactionType.SPOT    | "01/01/2017" | "01/01/2017" | true
        TransactionType.SPOT    | "01/01/2017" | "02/01/2017" | true
        TransactionType.SPOT    | "01/01/2017" | "03/01/2017" | true
        TransactionType.SPOT    | "01/01/2017" | "04/01/2017" | false

        TransactionType.FORWARD | "01/01/2017" | "04/01/2017" | true
        TransactionType.FORWARD | "01/01/2017" | "05/01/2017" | true
        TransactionType.FORWARD | "01/01/2017" | "01/01/2017" | false
        TransactionType.FORWARD | "01/01/2017" | "02/01/2017" | false
    }

}