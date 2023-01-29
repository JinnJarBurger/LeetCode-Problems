package net.jinnjar.common.tree.binary;

/**
 * @author adnan
 * @since 2/18/2023
 */
public class Node {

    private final int key;
    private final int value;
    public Node next;
    public Node prev;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}
