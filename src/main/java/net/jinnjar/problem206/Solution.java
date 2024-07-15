package net.jinnjar.problem206;

import net.jinnjar.common.ListNode;

/**
 * adnan
 * 7/14/2024
 */
public class Solution {

    public ListNode reverseList(ListNode head) {
        return reverseListRecursive(null, head);
    }

    public ListNode reverseListIterative(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prevNode = head;
        ListNode currNode = head.next;

        while (currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;

            if (prevNode == head) {
                prevNode.next = null;
            }

            prevNode = currNode;
            currNode = nextNode;
        }

        return prevNode;
    }

    public ListNode reverseListRecursive(ListNode prevNode, ListNode currNode) {
        if (currNode == null) return prevNode;

        ListNode nextNode = currNode.next;
        currNode.next = prevNode;
        prevNode = currNode;
        currNode = nextNode;

        return reverseListRecursive(prevNode, currNode);
    }
}
