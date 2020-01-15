package io.rocketbase.lexoffice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaxConditions {

    @JsonProperty("taxType")
    private TaxType taxType;

    @JsonProperty("taxTypeNote")
    private String taxTypeNote;

}
