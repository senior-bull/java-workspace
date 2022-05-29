package com.bull.examples.vavr.basic;

import io.vavr.Tuple;
import io.vavr.Tuple2;

public class TuplesExample {

    public static void main(String[] args) {

        Tuple2<String, Integer> java8 = Tuple.of("Java", 8);
        System.out.println(java8);
        System.out.println(java8.append("ZZZ"));

        Tuple2<String, Integer> that = java8.map(
                s -> s.substring(2) + "vr",
                i -> i / 8
        );

        System.out.println(that);

        String apply = java8.apply((str, i) -> str + i);
        System.out.println(apply);
    }
}
