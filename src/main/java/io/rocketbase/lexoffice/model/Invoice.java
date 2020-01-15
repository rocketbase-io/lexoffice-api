package io.rocketbase.lexoffice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Invoice {

    @JsonProperty("id")
    private String id;

    @JsonProperty("organizationId")
    private String organizationId;

    @JsonProperty("createdDate")
    private Date createdDate;

    @JsonProperty("updatedDate")
    private Date updatedDate;

    @JsonProperty("version")
    private Long version;

    @JsonProperty("language")
    private String language;

    @JsonProperty("archived")
    private boolean archived;

    @JsonProperty("voucherStatus")
    private VoucherStatus voucherStatus;

    @JsonProperty("voucherNumber")
    private String voucherNumber;

    @JsonProperty("voucherDate")
    private Date voucherDate;

    @JsonProperty("address")
    private Address address;

    @Singular
    @JsonProperty("lineItems")
    private List<LineItem> lineItems;

    @JsonProperty("totalPrice")
    private TotalPrice totalPrice;

    @Singular
    @JsonProperty("taxAmounts")
    private List<TaxAmount> taxAmounts;

    @JsonProperty("taxConditions")
    private TaxConditions taxConditions;

    @JsonProperty("paymentConditions")
    private PaymentConditions paymentConditions;

    @JsonProperty("shippingConditions")
    private ShippingConditions shippingConditions;

    @JsonProperty("title")
    private String title;

    @JsonProperty("introduction")
    private String introduction;

    @JsonProperty("remark")
    private String remark;

    @JsonProperty("files")
    private Files files;
}
