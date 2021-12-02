package com.bull.examples.basic;

import io.vavr.Tuple;
import io.vavr.Tuple2;

public class Tuples {

    public static void main(String[] args) {

        Tuple2<String, Integer> java8 = Tuple.of("Java", 8);
        System.out.println(java8);
    }
}
