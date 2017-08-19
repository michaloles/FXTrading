package com.olesm.trading.fxtrading.rest;

import com.olesm.trading.fxtrading.model.Trade;
import com.olesm.trading.fxtrading.rule.ValidationError;
import com.olesm.trading.fxtrading.service.TradeValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value="trade", description="Provide API for validating fx-traiding operationsss")
public class TradeController {

    //TODO Przeniesc komunikaty do pliku .properties
    //TODO Factory for creating validation rule set. Reuse created once.
    //TODO Add interaction tests
    //TODO albo swagger albo testy
    //TODO sprawdzic jakosc kodu w IntelliJ
    //TODO sprawdzic pokrycie testami

    @Autowired
    private TradeValidator tradeValidator;

    @ApiOperation("Validate if batch of trades meets business rules")
    @PostMapping(value = "/validate", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<ValidationError> validateTrades(@RequestBody List<Trade> tradeList){
        return tradeValidator.validate(tradeList);
    }

    @ApiOperation("Validate if single trade meet business rules")
    @PostMapping(value = "/validateOne", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<ValidationError> validateTrade(@RequestBody Trade trade){
        return tradeValidator.validate(trade);
    }

}