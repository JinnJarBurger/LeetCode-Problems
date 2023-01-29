package net.jinnjar.problem2130;

import net.jinnjar.common.ListNode;

/**
 * @author adnan
 * @since 5/17/2023
 */
public class Solution {

    public int pairSum(ListNode head) {
        // Solution 1 (Kinda Slow, Very Space Efficient)
        ListNode node = head;
        int[] pairArray = new int[1_000_000];
        int size = 0;

        while (node != null) {
            pairArray[size] = node.val;
            size++;
            node = node.next;
        }

        if (size == 1) return pairArray[0] + pairArray[1];

        int max = 0;
        int ind;

        for (int i = 1; i <= size; i++) {
            ind = size - i;

            if (ind >= 0 && (pairArray[ind] + pairArray[i]) > max) max = pairArray[ind] + pairArray[i];
        }

        return max;
    }
}
