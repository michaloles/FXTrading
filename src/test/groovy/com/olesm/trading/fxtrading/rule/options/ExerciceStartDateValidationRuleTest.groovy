package com.olesm.trading.fxtrading.rule.options

import com.olesm.trading.fxtrading.model.Option
import com.olesm.trading.fxtrading.model.OptionStyle
import spock.lang.Specification

class ExerciceStartDateValidationRuleTest extends Specification {

    def rule = new ExerciceStartDateValidationRule()

    def "Should correctly validate exercice start date for american style option"() {
        when:
        def option = new Option(
                style: style,
                excerciseStartDate: exerciceStartDate ? new Date().parse('dd/MM/yyyy', exerciceStartDate) : null,
                tradeDate: new Date().parse('dd/MM/yyyy', tradeDate),
                expiryDate: new Date().parse('dd/MM/yyyy', expiryDate)
        )

        then:
        rule.validate(option).isEmpty() == correct

        where:
        style                | exerciceStartDate | tradeDate    | expiryDate   | correct
        OptionStyle.EUROPEAN | "01/01/2017"      | "02/01/2017" | "02/01/2017" | true
        OptionStyle.EUROPEAN | "02/01/2017"      | "01/01/2017" | "01/01/2017" | true
        OptionStyle.EUROPEAN | "01/01/2017"      | "02/01/2017" | "02/01/2017" | true
        OptionStyle.EUROPEAN | null              | "02/01/2017" | "02/01/2017" | true

        OptionStyle.AMERICAN | "02/01/2017"      | "01/01/2017" | "03/01/2017" | true
        OptionStyle.AMERICAN | "02/01/2017"      | "02/01/2017" | "03/01/2017" | false
        OptionStyle.AMERICAN | "02/01/2017"      | "01/01/2017" | "02/01/2017" | false
    }

}