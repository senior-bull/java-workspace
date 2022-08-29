package com.bull.functional.basic;

import java.util.function.Function;

public class Compose {

    static Function<Integer, Integer> compose(Function<Integer, Integer> f1,
                                              Function<Integer, Integer> f2) {
        return arg -> f1.apply(f2.apply(arg));
    }

    public static void main(String[] args) {

        System.out.println(
            compose(x -> x * x, x -> x + 2).apply(5)
        );
    }
}
