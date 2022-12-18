package com.bull.features.pmatching;

public class AsyncResultPMatchingTest {

    sealed interface AsyncReturn<V> {
        record Success<V>(V result) implements AsyncReturn<V> { }
        record Failure<V>(Throwable cause) implements AsyncReturn<V> { }
        record Timeout<V>() implements AsyncReturn<V> { }
        record Interrupted<V>() implements AsyncReturn<V> { }
    }

    public static void main(String[] args) {

    }
}
