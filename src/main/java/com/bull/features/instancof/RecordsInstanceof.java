package com.bull.features.instancof;

public class RecordsInstanceof {

    record Point(int x, int y) {}

    record Circle(Point center, int radius) {}

    public static void main(String[] args) {
        Object obj = new Point(2, 5);
        if (obj instanceof Point(int x, int y)) {
            System.out.println(x);
            System.out.println(y);
        }

        Object obj2 = new Circle(new Point(5, 6), 2);
        if (obj2 instanceof Circle(Point(int x, int y), int rad)) {
            System.out.println(rad);
        }
    }
}
