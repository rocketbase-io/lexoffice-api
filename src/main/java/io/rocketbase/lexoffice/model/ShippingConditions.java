package io.rocketbase.lexoffice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShippingConditions {

    @JsonProperty("shippingDate")
    private Date shippingDate;

    @JsonProperty("shippingEndDate")
    private Date shippingEndDate;

    @JsonProperty("shippingType")
    private ShippingType shippingType;

}
