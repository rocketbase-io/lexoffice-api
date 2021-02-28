# Java Client of Lexoffice API

This project is a Java client for the public [lexoffice--developer-api](https://developers.lexoffice.io).

## Maven

The project is currently not published on maven-central you can easily use it via [jitpack.io](https://jitpack.io/#rocketbase-io/lexoffice-api/)

## Usage

### Query Contacts

````java
LexofficeApi lexofficeApi = new LexofficeApiBuilder()
        .apiToken( "your-api-token")
        .build();

Page<Contact> resultList = lexofficeApi.contact().fetch()
        .customer(true)
        .get();
````

### Create Invoice

````java
LexofficeApi lexofficeApi = getLexofficeApi();

int daysToPay = 14;
Invoice invoice = Invoice.builder()
        .title("Rechnung")
        .introduction("vielen Dank für Ihren Auftrag, den wir wie folgt berechnen:")
        .remark("Besten Dank und freundliche Grüße,")
        .language("de")
        .archived(false)
        .voucherDate(new Date())
        .paymentConditions(PaymentConditions.builder()
                .paymentTermLabel(String.format("Zahlung innerhalb von %d Tagen ab Rechnungseingang ohne Abzüge.", daysToPay))
                .paymentTermDuration(daysToPay)
                .build())
        .address(Address.builder()
                .contactId("contact-uuid")
                .build())
        .totalPrice(TotalPrice.builder()
                .currency(Currency.EUR)
                .totalNetAmount(BigDecimal.valueOf(31429, 2))
                .build())
        .shippingConditions(ShippingConditions.builder()
                .shippingDate(new Date())
                .shippingType(ShippingType.DELIVERY)
                .build())
        .taxConditions(new TaxConditions(TaxType.NET, ""))
        .lineItems(Arrays.asList(LineItem.builder()
                        .type(LineItemType.CUSTOM)
                        .name("Name")
                        .description("Eine längere Beschreibung\nMehrzeilig funktioniert auch...")
                        .unitName("Stück")
                        .unitPrice(UnitPrice.builder()
                                .netAmount(BigDecimal.valueOf(5055, 2))
                                .taxRatePercentage(19)
                                .currency(Currency.EUR)
                                .build())
                        .lineItemAmount(BigDecimal.valueOf(30330, 2))
                        .quantity(BigDecimal.valueOf(6))
                        .build(),
                LineItem.builder()
                        .type(LineItemType.CUSTOM)
                        .name("Second")
                        .unitName("Stück")
                        .unitPrice(UnitPrice.builder()
                                .netAmount(BigDecimal.valueOf(1099, 2))
                                .taxRatePercentage(19)
                                .currency(Currency.EUR)
                                .build())
                        .lineItemAmount(BigDecimal.valueOf(1099, 2))
                        .quantity(BigDecimal.valueOf(1))
                        .build()))
        .build();

lexofficeApi.invoice().create().submit(invoice);
````

### The MIT License (MIT)
Copyright (c) 2021 rocketbase.io

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
