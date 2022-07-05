package com.bull.examples.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GroupTest {

    public static final List<Person> data = List.of(
            new Person("Vito", "Bykov", 30),
            new Person("Vito", "Carleone", 70),
            new Person("John", "Doe", 30),
            new Person("John", "Lennon", 50),
            new Person("James", "A", 35)
    );

    public static final class SimpleListCollector<T> implements Collector<T, T, List<T>> {

        @Override
        public Supplier<T> supplier() {
            return null;
        }

        @Override
        public BiConsumer<T, T> accumulator() {
            return null;
        }

        @Override
        public BinaryOperator<T> combiner() {
            return null;
        }

        @Override
        public Function<T, List<T>> finisher() {
            return null;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Set.of(Characteristics.UNORDERED);
        }
    }

    public static void main(String[] args) {
        data.stream().collect();
    }
}
