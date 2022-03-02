package com.ch12.algo.nodes.LinkedList;

public class LinkedList {
    public static void main(String[] args) {
        Node<Integer> head = null;
        head = recAddNode(head, 2);
        head = recAddNode(head, 8);
        head = recAddNode(head, 5);
        head = recAddNode(head, 9);

        assertResult(head.value == 2);
        assertResult(head.next.value == 8);
        assertResult(head.next.next.value == 5);
        assertResult(head.next.next.next.value == 9);

        displayList(head); //2859
        displayList(find(head,5)); // 59
        displayList(find(head, 8)); // 859
        head = remove(head, 5); //nothing
        displayList(head); //289
        head = remove(head,2);
        displayList(head); // 89
        addNode(head,42);
        displayList(head); // 8, 9, 42
    }

    // while (trav.next != null) will go till last node but will not run the last node through loop logic.
    // while (trav != null) will go through all nodes and apply loop logic to all nodes.

    // returns the head of the list
    public static Node<Integer> addNode(Node<Integer> head, int value) {
        Node<Integer> newNode = new Node<Integer>(value);
        if (head == null) {
            return newNode;
        }
        Node<Integer> trav = head;
        while (trav.next != null) { //while not end of list
            trav = trav.next;
        }
        // trav is at the end of the list
        trav.next = newNode;
        return head;
    }

    public static Node<Integer> recAddNode(Node<Integer> head, int value){
        // only add the value as a new node onto a node with a next == null.
        if(head == null) {
            return new Node<Integer>(value);
        }

        head.next = recAddNode(head.next, value);
        return head;

    }

    public static void displayList(Node<Integer> head) {
        // output should be 2859 additional challenge 2, 8, 5, 9
        Node<Integer> trav = head;
        StringBuilder output = new StringBuilder();
        while (trav != null) {
            output.append(trav.value);
            if (trav.next != null) {
                output.append(", ");
            }
            trav = trav.next;
        }
        System.out.println(output);

    }

    public static Node<Integer> find(Node<Integer> head, int query) {
        Node<Integer> trav = head;
        while (trav != null && trav.value != query) {
            trav = trav.next;
        }
        // trav = null so no additional checks
        return trav;
    }
    // 0. Integer return the query if found null if not
    // 1. int return the index if found or -1 if not found
    // 2. Node return of the node object that contains the query of null if not found


    public static Node<Integer> remove(Node<Integer> head, int query) {
        // TODO: check head first.
        if (head.value == query) {
            head = head.next;
            return head;
        }
        Node<Integer> trav = head;
        while (trav.next != null  && trav.next.value != query) {
            trav = trav.next;
        }
        // trav is now pointing at the node before the "badnode"
        trav.next = trav.next.next;
        return head;
    }

    public static void assertResult(boolean result) {
        if (result) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
    }
}
