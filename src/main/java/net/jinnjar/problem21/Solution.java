package net.jinnjar.problem21;

import net.jinnjar.common.ListNode;

/**
 * @author adnan
 * @since 7/17/24
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode list3 = new ListNode(list1.val);
        ListNode head = list3;

        if (list1.val > list2.val) {
            list3.val = list2.val;

            list2 = list2.next;
        } else {
            list1 = list1.next;
        }

        while (list1 != null && list2 != null) {
            if (list1.val >= list3.val && list1.val <= list2.val) {
                list3.next = new ListNode(list1.val);
                list1 = list1.next;
            } else if (list2.val >= list3.val && list2.val <= list1.val) {
                list3.next = new ListNode(list2.val);
                list2 = list2.next;
            }

            list3 = list3.next;
        }

        while (list1 != null) {
            list3.next = new ListNode(list1.val);
            list1 = list1.next;
            list3 = list3.next;
        }

        while (list2 != null) {
            list3.next = new ListNode(list2.val);
            list2 = list2.next;
            list3 = list3.next;
        }

        return head;
    }
}
