package com.bull.examples.vavr.collections;

import io.vavr.collection.List;
import io.vavr.collection.Seq;

public class SeqMethodsExample {

    public static void main(String[] args) {

        Seq<String> set = List.of("AB", "CD", "EF", "DF");
        Seq<String> appended = set.append("BC");

        System.out.println("Original: " + set);
        System.out.println("Appended: " + appended);
    }
}
