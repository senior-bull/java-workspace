package com.bull.functional.examples;

public interface Effect<T> {
    void apply(T t);
}