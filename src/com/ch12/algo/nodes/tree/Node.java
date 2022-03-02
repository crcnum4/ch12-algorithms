package com.ch12.algo.nodes.tree;

public class Node<T> {
    public T value;

    public Node<T> left;
    public Node<T> right;

    public Node(T value) {
        this.value = value;
    }
}