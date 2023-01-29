package net.jinnjar.common;

public class SinglyLinkedList {

    public ListNode head = null;
    public ListNode tail = null;

    public void addNode(int data) {
        ListNode newNode = new ListNode(data);

        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }

        tail = newNode;
    }

    public void display() {
        ListNode current = head;

        if (head == null) {
            return;
        }

        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }

        System.out.println();
    }
}
