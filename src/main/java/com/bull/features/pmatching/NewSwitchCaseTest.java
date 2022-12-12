package com.bull.features.pmatching;

import java.util.Arrays;

public class NewSwitchCaseTest {

    static String smartToString(Object o) {
        return switch (o) {
            case null -> "null";
            case String s -> s;
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
    }
}
