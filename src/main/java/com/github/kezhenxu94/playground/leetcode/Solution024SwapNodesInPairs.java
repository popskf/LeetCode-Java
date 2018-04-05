package com.github.kezhenxu94.playground.leetcode;

/**
 * 24. Swap Nodes in Pairs
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
 *
 * TODO Optimize
 *
 * @author ke.zhen.xu
 */
public class Solution024SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return head;

        ListNode first = head;
        ListNode second = head.next;
        if (second != null) {    // has pair node
            first.next = second.next;
            second.next = first;
            first.next = swapPairs(first.next);
            return second;
        }
        return first;
    }

}
