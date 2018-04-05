package com.github.kezhenxu94.playground.leetcode;

/**
 * 206. Reverse Linked List
 *
 * Reverse a singly linked list.
 *
 * Hint:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class Solution206ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode result = head;
        ListNode temp;
        while ((temp = head) != null) {
            head = temp.next;
            temp.next = result;
            result = temp;
        }
        return result;
    }
}
