package com.bull.examples.vavr.basic;

import io.vavr.control.Either;

public class EitherExample {

    public static Either<String, Integer> compute() {
        return Either.left("ABC");
    }

    public static void main(String[] args) {

        Either<String,Integer> value = compute().right().map(i -> i * 2).toEither();

        System.out.println(value);
    }
}
