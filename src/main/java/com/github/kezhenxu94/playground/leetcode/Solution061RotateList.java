package com.github.kezhenxu94.playground.leetcode;

/**
 * <pre>
 *
 * 61. Rotate List
 *
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative.
 *
 * For example: Given 1->2->3->4->5->NULL and k = 2,
 *
 * return 4->5->1->2->3->NULL.
 *
 * </pre>
 *
 * @author ke.zhen.xu
 */
public class Solution061RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        int len = 1;
        ListNode tail = head;
        for (; tail.next != null; tail = tail.next, len++)
            ;
        tail.next = head;

        ListNode result = tail.next;
        for (int i = 0; i < len - (k % len); i++) {
            tail = result;
            result = result.next;
        }
        tail.next = null;
        return result;
    }
}