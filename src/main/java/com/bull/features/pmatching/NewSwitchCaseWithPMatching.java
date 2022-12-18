package com.bull.features.pmatching;

import java.util.Arrays;
import java.util.List;

public class NewSwitchCaseTest {

    static void smartPrint(Object o) {
        switch (o) {
            case null -> System.out.println("NULL");
            case String s -> System.out.println(s);
            case Integer n -> System.out.println(n);
            case int[] ia -> System.out.println(Arrays.toString(ia));
            case List<?> is when is.size() > 3 -> System.out.println(is.subList(0, 3) + "...");
            case List<?> is -> System.out.println(is);
            default -> o.toString();
        };
    }

    static String smartToString(Object o) {
        return switch (o) {
            case null -> "null";
            case String s -> s;
            case Integer n -> n.toString();
            case int[] ia -> Arrays.toString(ia);
            default -> o.toString();
        };
    }

    private static class X {

    }

    public static void main(String[] args) {
        System.out.println(smartToString(null));
        System.out.println(smartToString("ABASDASD"));
        System.out.println(smartToString(new int[] {1, 2, 3}));
        System.out.println(smartToString(new X()));

        smartPrint(Arrays.asList("A", "B", "C", "D", "E"));
        smartPrint(Arrays.asList("A", "B", "C"));
    }
}
