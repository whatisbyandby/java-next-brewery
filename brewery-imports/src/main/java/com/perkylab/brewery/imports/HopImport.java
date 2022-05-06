package com.perkylab.brewery.imports;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class HopImport {
    @JsonProperty("NAME")
    private String name;

    @JsonProperty("VERSION")
    private Integer version;

    @JsonProperty("ORIGIN")
    private String origin;

    @JsonProperty("ALPHA")
    private BigDecimal alpha;

    @JsonProperty("AMOUNT")
    private BigDecimal amount;

    @JsonProperty("USE")
    private String use;

    @JsonProperty("TIME")
    private BigDecimal time;

    @JsonProperty("NOTES")
    private String notes;

    @JsonProperty("TYPE")
    private String type;

    @JsonProperty("FORM")
    private String form;

    @JsonProperty("BETA")
    private BigDecimal beta;

    @JsonProperty("HSI")
    private BigDecimal hsi;

    @JsonProperty("DISPLAY_AMOUNT")
    private String displayAmount;

    @JsonProperty("INVENTORY")
    private String inventory;

    @JsonProperty("DISPLAY_TIME")
    private String displayTime;

}
