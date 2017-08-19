package com.olesm.trading.fxtrading.rule.options

import com.olesm.trading.fxtrading.model.Option
import spock.lang.Specification

class ExpiryDateAndPremiumDateMustBeBeforeDeliveryDateRuleTest extends Specification {

    def rule = new ExpiryDateAndPremiumDateMustBeBeforeDeliveryDateRule()

    def "Should correctly validate if value date is after trade date"() {
        when:
        def option = new Option(
                expiryDate: new Date().parse('dd/MM/yyyy', expiryDate),
                premiumDate: new Date().parse('dd/MM/yyyy', premiumDate),
                deliveryDate: new Date().parse('dd/MM/yyyy', deliveryDate)
        )

        then:
        rule.validate(option).isEmpty() == correct

        where:
        expiryDate   | premiumDate  | deliveryDate | correct
        "01/01/2017" | "01/01/2017" | "02/01/2017" | true
        "02/01/2017" | "01/01/2017" | "01/01/2017" | false
        "01/01/2017" | "02/01/2017" | "01/01/2017" | false
        "02/01/2017" | "02/01/2017" | "01/01/2017" | false
    }

}