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

        // This special kind of function, taking functions as its arguments
        // and returning functions, is called a higher-order function (HOF)
        Function<Function<Integer, Integer>,
            Function<Function<Integer, Integer>,
                Function<Integer, Integer>>> compose =
            x -> y -> z -> x.apply(y.apply(z));

        Integer val = compose.apply(x -> x * x).apply(x -> x + 2).apply(5);
        System.out.println(val);
    }
}
