package com.hts.sec02;

import com.hts.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class Lec06MonoFromCallable {

    public static final Logger logger = LoggerFactory.getLogger(Lec06MonoFromCallable.class);

    public static void main(String[] args) {

        var list = List.of(1, 2, 3);
        Mono.fromCallable(() -> sum(list)).subscribe(Util.subscriber());

        // Note that supplier doesn't throw exception except that it's a runtime exception. so it has no exception as
        // part of its method signature. The opposite is true for callable. If in case you want to use exception for a
        // supplier, you have to use a try / catch block.

    }

    private static int sum(List<Integer> list) throws Exception {
        logger.info("finding the sum of {}", list);
        return list.stream().mapToInt(a -> a).sum();
    }

}
