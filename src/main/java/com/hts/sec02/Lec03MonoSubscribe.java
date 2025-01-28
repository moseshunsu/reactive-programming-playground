package com.hts.sec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

    public static final Logger logger = LoggerFactory.getLogger(Lec03MonoSubscribe.class);

    public static void main(String[] args) {

        var mono = Mono.just(1);

        mono.subscribe(
                i -> logger.info("received: {}", i),
                err -> logger.error("error", err),
                () -> logger.info("completed"),
                subscription -> subscription.request(1));

    }

}
