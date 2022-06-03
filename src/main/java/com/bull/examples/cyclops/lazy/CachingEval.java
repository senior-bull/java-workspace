package com.bull.examples.cyclops.lazy;

import cyclops.control.Eval;

public class CachingEval {

    private static Eval<String> data = Eval.later(() -> {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ABC";
    });

    public static void main(String[] args) {

        System.out.println(data.get());
        System.out.println(data.get());
        System.out.println(data.get());
    }
}
