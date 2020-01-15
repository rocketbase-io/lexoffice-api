package io.rocketbase.lexoffice;

import io.rocketbase.lexoffice.chain.ContactChain;
import io.rocketbase.lexoffice.chain.InvoiceChain;
import io.rocketbase.lexoffice.chain.VoucherListChain;

public class LexofficeApi {

    private final RequestContext context;

    LexofficeApi(RequestContext context) {
        this.context = context;
    }

    public VoucherListChain voucherList() {
        return new VoucherListChain(context);
    }

    public ContactChain contact() {
        return new ContactChain(context);
    }

    public InvoiceChain invoice() {
        return new InvoiceChain(context);
    }

}
