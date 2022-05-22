package com.bull.examples.vavr.functional;

import io.vavr.Function2;
import io.vavr.control.Option;

public class LiftingExample {

    public static void main(String[] args) {

        Function2<Integer, Integer, Integer> divide = (a, b) -> a / b;
        Function2<Integer, Integer, Option<Integer>> safeDivide = Function2.lift(divide);

        System.out.println(safeDivide.apply(4, 2));
        System.out.println(safeDivide.apply(4, 0));

    }
}
