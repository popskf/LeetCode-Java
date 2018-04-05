package com.github.kezhenxu94.playground.leetcode;

/**
 * 83. Remove Duplicates from Sorted List
 *
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 *
 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3.
 *
 * @author Ke Zhenxu
 */
public class Solution083RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;

        ListNode result = head;
        ListNode tail = head;
        head = head.next;

        for (ListNode temp = head; temp != null; temp = temp.next) {
            if (temp.val > tail.val) {
                tail.next = temp;
                tail = temp;
            }
        }
        tail.next = null;
        return result;
    }
}
