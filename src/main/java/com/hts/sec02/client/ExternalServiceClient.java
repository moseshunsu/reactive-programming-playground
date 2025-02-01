package com.hts.sec02.client;

import com.hts.common.AbstractHttpClient;
import reactor.core.publisher.Mono;

public class ExternalServiceClient extends AbstractHttpClient {

    /*
    When this method is invoked, we crate a Mono which is capable of sending a request.
    But the actual HTTP request is sent, only when it is subscribed.
     */
    public Mono<String> getProductName(int productId) {
        return this.httpClient.get()
                .uri("/demo01/product/" + productId)
                .responseContent()
                .asString()
                .next(); // next converts the flux into a mono. Next is similar to find first in Java streams.
    }

}
