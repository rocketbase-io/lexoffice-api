package io.rocketbase.lexoffice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Addresses {

    @Singular
    @JsonProperty("billing")
    private List<Address> billings;

    @Singular
    @JsonProperty("shipping")
    private List<Address> shippings;
}
