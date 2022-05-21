package com.bull.examples.vavr.functional;

import io.vavr.Function1;

public class CompositionExample {

    public static void main(String[] args) {

        Function1<Integer, Integer> plusOne = a -> a + 1;
        Function1<Integer, Integer> multiplyByTwo = a -> a * 2;

        Function1<Integer, Integer> composed = plusOne.andThen(multiplyByTwo);

        System.out.println(composed.apply(5));
        System.out.println(composed.apply(10));
    }
}
