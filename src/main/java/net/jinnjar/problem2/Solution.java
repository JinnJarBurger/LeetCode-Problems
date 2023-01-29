package net.jinnjar.problem2;

import net.jinnjar.common.ListNode;

/**
 * @author adnan
 * @since 1/28/2023
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test values
        int[] firstValues = {2, 4, 3};
        int[] secondValues = {5, 6, 4};

        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();

        ListNode node1 = new ListNode();
        ListNode node2;

        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                l1.val = firstValues[i];
                node1 = l1;
            } else {
                node2 = new ListNode();
                node2.val = firstValues[i];
                node1.next = node2;
                node1 = node2;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                l2.val = secondValues[i];
                node1 = l2;
            } else {
                node2 = new ListNode();
                node2.val = secondValues[i];
                node1.next = node2;
                node1 = node2;
            }
        }

        solution.printNode(solution.addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode head = node;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;

            node.val = sum % 10;

            if (l1 != null || l2 != null || carry != 0) {
                node.next = new ListNode();
                node = node.next;
            }
        }

        return head;
    }

    private void printNode(ListNode node) {
        System.out.println(node.val);

        if (node.next == null) {
            return;
        }

        printNode(node.next);
    }
}
