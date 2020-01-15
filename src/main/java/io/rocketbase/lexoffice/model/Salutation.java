package io.rocketbase.lexoffice.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum Salutation {

    MISTER("Herr"),
    MISS("Frau");

    @Getter
    @JsonValue
    private String value;

    Salutation(String value) {
        this.value = value;
    }

}
