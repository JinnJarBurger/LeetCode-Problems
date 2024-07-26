package net.jinnjar.problem141;

import net.jinnjar.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * adnan
 * 7/19/2024
 */
public class Solution {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while (head != null) {
            if (set.contains(head)) {
                return true;
            }

            set.add(head);
            head = head.next;
        }

        return false;
    }
}
