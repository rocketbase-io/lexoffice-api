package io.rocketbase.lexoffice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company {

    @JsonProperty("name")
    private String name;

    @JsonProperty("taxNumber")
    private String taxNumber;

    @JsonProperty("vatRegistrationId")
    private String vatRegistrationId;

    @JsonProperty("allowTaxFreeInvoices")
    private boolean allowTaxFreeInvoices;

    @Singular
    @JsonProperty("contactPersons")
    private List<ContactPerson> contactPersons;
}
