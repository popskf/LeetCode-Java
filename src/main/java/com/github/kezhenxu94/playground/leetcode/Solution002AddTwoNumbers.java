package com.github.kezhenxu94.playground.leetcode;

/**
 * 2. Add Two Numbers
 *
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 * @author ke.zhen.xu
 */
public class Solution002AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carrier = 0;
        ListNode result = new ListNode(0);
        ListNode last = result;
        while (true) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carrier;
            carrier = sum / 10;
            last.next = new ListNode(sum % 10);
            last = last.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            if (l1 == null && l2 == null) {
                break;
            }
        }
        if (carrier > 0) {
            last.next = new ListNode(carrier);
        }
        return result.next;
    }
}
