package com.bull.functional.examples;

import java.util.function.Supplier;

// TODO use extends Tuple
public class Case<T> {

    protected final Supplier<Boolean> condition;
    protected final Supplier<Result<T>> value;

    public Case(Supplier<Boolean> condition, Supplier<Result<T>> value) {
        this.condition = condition;
        this.value = value;
    }

    private static class DefaultCase<T> extends Case<T> {

        private DefaultCase(Supplier<Boolean> condition, Supplier<Result<T>> resultSupplier) {
            super(condition, resultSupplier);
        }
    }

    public static <T> Case<T> mcase(Supplier<Boolean> condition, Supplier<Result<T>> value) {
        return new Case<>(condition, value);
    }

    public static <T> DefaultCase<T> mcase(Supplier<Result<T>> value) {
        return new DefaultCase<>(() -> true, value);
    }

    public static <T> Result<T> match(DefaultCase<T> defaultCase, Case<T>... matchers) {
        for (Case<T> aCase : matchers) {
            if (aCase.condition.get()) return aCase.value.get();
        }
        return defaultCase.value.get();
    }
}
