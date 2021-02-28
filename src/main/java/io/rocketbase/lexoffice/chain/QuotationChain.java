package io.rocketbase.lexoffice.chain;

import io.rocketbase.lexoffice.RequestContext;
import io.rocketbase.lexoffice.model.Invoice;
import io.rocketbase.lexoffice.model.Quotation;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

@RequiredArgsConstructor
public class QuotationChain {

    private final RequestContext context;

    public Quotation get(String id) {
        return new Get(context).get(id);
    }

    public Create create() {
        return new Create(context);
    }

    protected static class Get extends ExecutableRequestChain {
        private static final ParameterizedTypeReference<Quotation> TYPE_REFERENCE = new ParameterizedTypeReference<Quotation>() {
        };

        public Get(RequestContext context) {
            super(context, "/quotations");
        }

        @SneakyThrows
        public Quotation get(String id) {
            getUriBuilder().appendPath("/" + id);
            return getContext().execute(getUriBuilder(), HttpMethod.GET, TYPE_REFERENCE);
        }
    }

    public static class Create extends ExecutableRequestChain {
        private static final ParameterizedTypeReference<Quotation> TYPE_REFERENCE = new ParameterizedTypeReference<Quotation>() {
        };

        public Create(RequestContext context) {
            super(context, "/quotations");
        }

        public Create finalize(Boolean finalize) {
            super.getUriBuilder()
                    .addParameter("finalize", finalize);
            return this;
        }

        @SneakyThrows
        public Quotation submit(Quotation quotation) {
            return getContext().execute(getUriBuilder(), HttpMethod.POST, quotation, TYPE_REFERENCE);
        }
    }

}
