package com.bull.features.pmatching;

// https://www.infoq.com/articles/data-oriented-programming-java/

import java.util.function.Function;

sealed interface Opt<T> {
    record Some<T>(T value) implements Opt<T> { }
    record None<T>() implements Opt<T> { }
}

class Operations {
    static<T, U> Opt<U> map(Opt<T> opt, Function<T, U> mapper) {
        return switch (opt) {
            case Opt.Some<T>(var v) -> new Opt.Some<>(mapper.apply(v));
            case Opt.None<T>() -> new Opt.None<>();
        };
    }
}

public class OptionalTest {

    public static Opt<String> find(int i) {
        if (i >= 0) {
            return new Opt.Some<>("" + i);
        } else {
            return new Opt.None<>();
        }
    }

    public static void main(String[] args) {
        var result = Operations.map(
            find(5),
            val -> val + "ABC"
        );
        var s = switch (result) {
            case Opt.Some<String> str -> "has some " + str.value();
            case Opt.None<String> non -> "none";
        };
        System.out.println(s);
    }
}