package net.jinnjar.common;

import net.jinnjar.common.tree.binary.Node;

import static java.util.Objects.isNull;

/**
 * @author adnan
 * @since 2/18/2023
 */
public class DoubleLinkedList {


    private int size;
    private Node head;
    private Node tail;

    public void add(Node node) {
        if (isNull(head)) {
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }

        tail = node;
        size++;
    }

    public void remove(Node node) {

        if (isNull(node.next)) {
            tail = node.prev;
        } else {
            node.next.prev = node.prev;
        }

        if (isNull(node.prev)) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }

        node.next = null;
        node.prev = null;
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node head() {
        return head;
    }

    public int size() {
        return size;
    }
}
