package com.bull.examples.vavr.functional;

import io.vavr.Function1;
import io.vavr.Function2;

public class CurryingExample {

    public static void main(String[] args) {
        Function2<Integer, Integer, Integer> sum = (a, b) -> a + b;
        Function1<Integer, Integer> add2 = sum.curried().apply(2);

        System.out.println(add2.apply(4));
        System.out.println(add2.apply(10));
    }
}
