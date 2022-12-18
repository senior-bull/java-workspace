package com.bull.features.pmatching;

sealed interface Tree<T> {
    record Nil<T>() implements Tree<T> {}
    record Node<T>(Tree<T> left, T val, Tree<T> right) implements Tree<T> { }

    static <T> boolean contains(Tree<T> tree, T target) {
        return switch (tree) {
            case Tree.Nil<T>() -> false;
            case Tree.Node<T>(var left, var val, var right) ->
                target.equals(val) || contains(left, target) || contains(right, target);
        };
    }
}

public class TreePMatching {

    public static void main(String[] args) {
        Tree.Node<String> nnode = new Tree.Node<>(
            new Tree.Node<>(new Tree.Nil<>(), "ABC", new Tree.Nil<>()),
            "CDE",
            new Tree.Node<>(new Tree.Nil<>(), "DEF", new Tree.Nil<>())
        );

        System.out.println(Tree.contains(nnode, "DEF"));
    }
}
