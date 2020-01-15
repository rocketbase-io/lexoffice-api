package io.rocketbase.lexoffice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailAddresses {

    @Singular
    @JsonProperty("business")
    private List<String> businesses;

    @Singular
    @JsonProperty("office")
    private List<String> offices;

    @Singular
    @JsonProperty("private")
    private List<String> privates;

    @Singular
    @JsonProperty("other")
    private List<String> others;
}
