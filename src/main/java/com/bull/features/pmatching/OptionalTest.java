package com.bull.features.pmatching;

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
        var s = switch (result) {
            case Opt.Some<String> z -> 5;
            case Opt.None $ -> 6;
        };
        System.out.println(s);
    }
}