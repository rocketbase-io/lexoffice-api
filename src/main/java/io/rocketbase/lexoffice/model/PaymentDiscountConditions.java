package io.rocketbase.lexoffice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDiscountConditions {

    @JsonProperty("discountPercentage")
    private Long discountPercentage;

    @JsonProperty("discountRange")
    private Long discountRange;

}
