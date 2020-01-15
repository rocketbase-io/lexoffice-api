package io.rocketbase.lexoffice.chain;

import io.rocketbase.lexoffice.RequestContext;
import io.rocketbase.lexoffice.model.Invoice;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

@RequiredArgsConstructor
public class InvoiceChain {

    private final RequestContext context;

    public Invoice get(String id) {
        return new Fetch(context).get(id);
    }

    protected static class Fetch extends ExecutableRequestChain {
        private static final ParameterizedTypeReference<Invoice> TYPE_REFERENCE = new ParameterizedTypeReference<Invoice>() {
        };

        public Fetch(RequestContext context) {
            super(context, "/invoices");
        }

        @SneakyThrows
        public Invoice get(String id) {
            getUriBuilder().appendPath("/" + id);
            return getContext().execute(getUriBuilder(), HttpMethod.GET, TYPE_REFERENCE);
        }
    }

}
