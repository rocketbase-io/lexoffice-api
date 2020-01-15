package io.rocketbase.lexoffice.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum VoucherType {

    INVOICE("invoice"),
    CREDITNOTE("creditnote"),
    ORDERCONFIRMATION("orderconfirmation"),
    QUOTATION("quotation");

    @Getter
    @JsonValue
    private String value;

    VoucherType(String value) {
        this.value = value;
    }

}
