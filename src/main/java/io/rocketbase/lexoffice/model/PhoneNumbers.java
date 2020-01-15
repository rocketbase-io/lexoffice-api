package io.rocketbase.lexoffice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhoneNumbers {

    @Singular
    @JsonProperty("business")
    private List<String> businesses;

    @Singular
    @JsonProperty("office")
    private List<String> offices;

    @Singular
    @JsonProperty("mobile")
    private List<String> mobiles;

    @Singular
    @JsonProperty("private")
    private List<String> privates;

    @Singular
    @JsonProperty("fax")
    private List<String> faxes;

    @Singular
    @JsonProperty("other")
    private List<String> others;
}
