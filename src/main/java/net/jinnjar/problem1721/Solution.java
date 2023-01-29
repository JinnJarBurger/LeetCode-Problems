package net.jinnjar.problem1721;

import net.jinnjar.common.ListNode;

/**
 * @author adnan
 * @since 5/16/2023
 */
public class Solution {

    public ListNode swapNodes(ListNode head, int k) {
        // Solution 1 (Not very fast, Very space efficient)
        if (head.next == null) return head;

        int indexTwo, indexOneVal = -1, indexTwoVal = -1, i = 0, size = 0;
        ListNode node = head;

        while (node != null) {
            size++;
            node = node.next;
        }

        indexTwo = size - (k - 1);

        if (k == indexTwo) return head;

        node = head;

        while (node != null) {
            i++;

            if (i == k) indexOneVal = node.val;
            else if (i == indexTwo) indexTwoVal = node.val;

            node = node.next;
        }

        int maxInd = Math.max(k, indexTwo);
        node = head;
        i = 0;

        while (i <= maxInd && node != null) {
            i++;

            if (i == k) node.val = indexTwoVal;
            else if (i == indexTwo) node.val = indexOneVal;

            node = node.next;
        }

        return head;
    }
}
