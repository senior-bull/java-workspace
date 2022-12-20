package com.bull.features.instancof;

public class RecordsInstanceof {

    record Point(int x, int y) {}

    public static void main(String[] args) {
        Object obj = new Point(2, 5);
        if (obj instanceof Point(int x, int y) p) {
            System.out.println(p);
            System.out.println(p.x);
            System.out.println(p.y);
        }
    }
}
