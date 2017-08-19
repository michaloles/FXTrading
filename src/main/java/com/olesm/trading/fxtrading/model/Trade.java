package com.olesm.trading.fxtrading.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type",
        defaultImpl = Trade.class,
        visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Option.class, name = "VanillaOption")
})
public class Trade {

    private String customer;
    private String ccyPair;
    private TransactionType type;
    private TransactionDirection direction;

    private BigDecimal amount1;
    private BigDecimal amount2;
    private BigDecimal rate;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date valueDate;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date tradeDate;

    private String trader;
    private String legalEntity;

}