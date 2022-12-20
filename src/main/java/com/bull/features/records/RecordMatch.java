package com.bull.features.records;

import java.util.List;

record Box(Object o) {}

public class RecordMatch {

    public static void main(String[] args) {
        List<Box> boxes = List.of(new Box("one"), new Box("two"), new Box(1), new Box(2));

        for (Box b : boxes) {

        }
    }
}
