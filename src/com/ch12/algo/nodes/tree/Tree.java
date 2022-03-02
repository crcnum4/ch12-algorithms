package com.ch12.algo.nodes.tree;

public class Tree {
    public static void main(String[] args) {
        Node<Integer> head = null;

        head = addNode(head, 6);
        head = addNode(head, 3);
        head = addNode(head, 9);
        head = addNode(head, 5);

        System.out.println(head.value);
        System.out.println(head.left.value + " " + head.right.value);
        System.out.println("  " + head.left.right.value);

    }

    public static Node<Integer> addNode(Node<Integer> head, Integer val) {
        if (head == null) {
            return new Node<>(val);
        }

        // what do we do if there is a node?
        Node<Integer> trav = head;

        while (true) {

            // where to go.
            if (val < trav.value) {
                // check for null.
                if (trav.left == null) {
                    trav.left = new Node<>(val);
                    return head;
                }
                // trav.left is not null
                trav = trav.left;
                continue;
            }

            if (val > trav.value) {
                if (trav.right == null) {
                    trav.right = new Node<>(val);
                    return head;
                }
                // trav.left is not null
                trav = trav.right;
                continue;
            }

            return head;
        }

    }
}
