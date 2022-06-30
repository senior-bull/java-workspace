/*
package com.bull.examples.dop;

// https://www.infoq.com/articles/data-oriented-programming-java/

sealed interface Opt<T> {
    record Some<T>(T value) implements Opt<T> { }
    record None<T>() implements Opt<T> { }
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
        var result = find(5);
        switch (result) {
            case Opt.Some<>(var value) -> {};
            case Opt.None<>() -> {};
        }
    }
}
*/
