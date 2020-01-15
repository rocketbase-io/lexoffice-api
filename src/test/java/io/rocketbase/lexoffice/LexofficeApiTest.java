package io.rocketbase.lexoffice;

import io.rocketbase.lexoffice.model.*;
import lombok.SneakyThrows;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Created by marten on 19.01.17.
 */
public class LexofficeApiTest {

    protected LexofficeApi getLexofficeApi() {
        String apiToken = "api_token";
        try {
            apiToken = System.getenv("LEXOFFICE_API_TOKEN");
        } catch (Exception e) {
            System.err.println("System Env not set use defaults");
        }

        return new LexofficeApiBuilder()
                .apiToken(apiToken)
                .build();
    }

    @SneakyThrows
    @Test
    public void fetchContacts() {
        LexofficeApi lexofficeApi = getLexofficeApi();

        Page<Contact> resultList = lexofficeApi.contact().fetch().get();

        assertThat(resultList, notNullValue());
    }

    @SneakyThrows
    @Test
    public void fetchVoucherList() {
        LexofficeApi lexofficeApi = getLexofficeApi();

        Page<Voucher> resultList = lexofficeApi.voucherList().get(VoucherStatus.OPEN, VoucherType.INVOICE);

        assertThat(resultList, notNullValue());
    }

    @SneakyThrows
    @Test
    public void getInvoice() {
        LexofficeApi lexofficeApi = getLexofficeApi();

        Invoice result = lexofficeApi.invoice().get("df22809b-1980-475d-be34-b420d62712b9");

        assertThat(result, notNullValue());
    }

}
