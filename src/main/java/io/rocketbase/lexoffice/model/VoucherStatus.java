package io.rocketbase.lexoffice.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum VoucherStatus {
    /**
     * editable later in lexoffice
     */
    DRAFT("draft"),
    /**
     * finished and no longer editable but not yet paid off
     */
    OPEN("open"),
    /**
     * has been fully paid back to the customer
     */
    PAIDOFF("paidoff"),
    /**
     * cancelled
     */
    VOIDED("voided"),

    OVERDUE("overdue");

    @Getter
    @JsonValue
    private String value;

    VoucherStatus(String value) {
        this.value = value;
    }

}
