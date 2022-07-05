package com.bull.examples.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CustomListCollectorTest {

    public static final List<Person> data = List.of(
            new Person("Vito", "Bykov", 30),
            new Person("Vito", "Carleone", 70),
            new Person("John", "Doe", 30),
            new Person("John", "Lennon", 50),
            new Person("James", "A", 35)
    );

    public static final class SimpleListCollector<T> implements Collector<T, ArrayList<T>, List<T>> {

        @Override
        public Supplier<ArrayList<T>> supplier() {
            return ArrayList::new;
        }

        @Override
        public BiConsumer<ArrayList<T>, T> accumulator() {
            return (list, x) -> list.add(x);
        }

        @Override
        public BinaryOperator<ArrayList<T>> combiner() {
            return (x, y) -> {
                if (x.size() > y.size()) {
                    x.addAll(y);
                    return x;
                } else {
                    y.addAll(x);
                    return y;
                }
            };
        }

        @Override
        public Function<ArrayList<T>, List<T>> finisher() {
            return list -> list;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Set.of(Characteristics.UNORDERED);
        }
    }

    public static void main(String[] args) {
        List<Person> toList = data.stream().collect(new SimpleListCollector<>());

        System.out.println(toList);
    }
}
