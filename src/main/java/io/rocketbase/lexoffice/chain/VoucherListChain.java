package io.rocketbase.lexoffice.chain;

import io.rocketbase.lexoffice.RequestContext;
import io.rocketbase.lexoffice.model.Page;
import io.rocketbase.lexoffice.model.Voucher;
import io.rocketbase.lexoffice.model.VoucherStatus;
import io.rocketbase.lexoffice.model.VoucherType;
import lombok.SneakyThrows;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

public class VoucherListChain extends ExecutableRequestChain {

    private static final ParameterizedTypeReference<Page<Voucher>> TYPE_REFERENCE = new ParameterizedTypeReference<Page<Voucher>>() {
    };
    private boolean voucherStatusAdded = false;
    private boolean voucherTypeAdded = false;

    public VoucherListChain(RequestContext context) {
        super(context, "/voucherlist");
    }

    /**
     * Pages are zero indexed, thus providing 0 for page will return the first page.
     */
    public VoucherListChain page(int page) {
        super.getUriBuilder()
                .addParameter("page", String.valueOf(page));
        return this;
    }

    /**
     * Default page size is set to 25 but can be increased up to 100/250 (depends on the used endpoint).
     */
    public VoucherListChain pageSize(int pageSize) {
        super.getUriBuilder()
                .addParameter("size", String.valueOf(pageSize));
        return this;
    }

    /**
     * Property significant to order of the contents. Possible values are voucherDate, voucherNumber, and updatedDate. The sort direction can be added separated by a comma. Possible values for the direction are ASC or DESC.
     */
    public VoucherListChain sort(String sort) {
        super.getUriBuilder()
                .addParameter("sort", sort);
        return this;
    }

    public VoucherListChain archived(boolean archived) {
        super.getUriBuilder()
                .addParameter("archived", String.valueOf(archived));
        return this;
    }

    @SneakyThrows
    public Page<Voucher> get(VoucherStatus voucherStatus, VoucherType voucherType) {
        super.getUriBuilder()
                .addParameter("voucherStatus", voucherStatus.getValue());
        super.getUriBuilder()
                .addParameter("voucherType", voucherType.getValue());

        return getContext().execute(getUriBuilder(), HttpMethod.GET, TYPE_REFERENCE);
    }

}
