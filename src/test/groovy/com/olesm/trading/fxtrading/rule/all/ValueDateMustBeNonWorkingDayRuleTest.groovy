package com.olesm.trading.fxtrading.rule.all

import com.olesm.trading.fxtrading.model.Trade
import spock.lang.Specification

class ValueDateMustBeNonWorkingDayRuleTest extends Specification {

    def rule = new ValueDateMustBeNonWorkingDayRule()

    def "Should correctly validate if value date is outiside weekend and public holiday"() {
        when:
        def trade = new Trade(
                valueDate: new Date().parse('dd/MM/yyyy', valueDate)
        )

        then:
        rule.validate(trade).isEmpty() == correct

        where:
        valueDate | correct
        //Holidays that should raise validation error
        "01/01/2017" | false
        "26/12/2017" | false
        "25/12/2016" | false
        "11/11/2016" | false
        "01/11/2016" | false
        //Weekend days (Saturday or Sunday) that should raise validation error
        "01/07/2017" | false
        "02/07/2017" | false
        "24/06/2017" | false
        "24/06/2017" | false
        //Correct work days that should pass validation
        "03/07/2017" | true
        "04/07/2017" | true
        "01/06/2016" | true
        "02/06/2016" | true
    }

}