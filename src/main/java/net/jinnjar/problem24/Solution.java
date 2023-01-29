package net.jinnjar.problem24;

import net.jinnjar.common.ListNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author adnan
 * @since 5/16/2023
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {
        // Solution 1 (Fastest, Less than average space complexity)
        if (head == null || head.next == null) return head;

        ListNode prevNode = head;
        ListNode currentNode = head.next;
        int tmpVal;

        while (currentNode != null) {
            if (prevNode == currentNode) {
                currentNode = currentNode.next;
                continue;
            }

            tmpVal = prevNode.val;
            prevNode.val = currentNode.val;
            currentNode.val = tmpVal;

            currentNode = currentNode.next;
            prevNode = currentNode;
        }

        return head;
    }
}
