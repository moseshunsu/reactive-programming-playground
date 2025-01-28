package com.hts.sec02;

import com.hts.common.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyError {

    public static void main(String[] args) {
        getUsername(3).subscribe(
//                Util.subscriber()
                s -> System.out.println(s),
                err -> {}
        );
    }

    private static Mono<String> getUsername(int userId){
        return switch (userId){
            case 1 -> Mono.just("Mos");
            case 2 -> Mono.empty();
            default -> Mono.error(new RuntimeException("invalid user id"));
        };
    }

}
