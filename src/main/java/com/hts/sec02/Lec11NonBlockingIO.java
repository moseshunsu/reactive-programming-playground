package com.hts.sec02;

import com.hts.common.Util;
import com.hts.sec02.client.ExternalServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec11NonBlockingIO {

    private static final Logger log = LoggerFactory.getLogger(Lec11NonBlockingIO.class);

    public static void main(String[] args) {

        var client = new ExternalServiceClient();

        log.info("starting");

        client.getProductName(1)
                .subscribe(Util.subscriber());

        Util.sleepSeconds(2);

    }

}
