package com.github.kezhenxu94.playground.leetcode;

/**
 * 86. Partition List
 *
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 *
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 *
 * @author ke.zhen.xu
 */
public class Solution086PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode lt = new ListNode(0);
        ListNode gt = new ListNode(0);
        ListNode lp = lt;
        ListNode gp = gt;
        for (ListNode node = head; node != null; node = node.next) {
            if (node.val < x) {
                lp.next = node;
                lp = lp.next;
            } else {
                gp.next = node;
                gp = gp.next;
            }
        }
        lp.next = gt.next;
        gp.next = null;
        return lt.next;
    }
}
