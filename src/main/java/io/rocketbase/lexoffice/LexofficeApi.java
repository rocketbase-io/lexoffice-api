package io.rocketbase.lexoffice;

import io.rocketbase.lexoffice.chain.ContactChain;
import io.rocketbase.lexoffice.chain.InvoiceChain;
import io.rocketbase.lexoffice.chain.QuotationChain;
import io.rocketbase.lexoffice.chain.VoucherListChain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class LexofficeApi {

    private final RequestContext context;

    public static DateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

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

    public QuotationChain quotation() {
        return new QuotationChain(context);
    }

}
