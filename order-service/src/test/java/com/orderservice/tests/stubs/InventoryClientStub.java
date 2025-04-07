package com.orderservice.tests.stubs;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class InventoryClientStub {

    //This method is the mocking, making a stub call to the url and it bringing this defined response.
    public static void stubInventoryCall(String skuCode, Integer quantity){
        stubFor(get(urlEqualTo("/api/v1/inventory?skuCode=" + skuCode + "&quantity=" + quantity))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("true")));

        stubFor(get(urlEqualTo("/api/v1/inventory?skuCode=" + skuCode + "&quantity=" + quantity))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("true")));
    }



}
