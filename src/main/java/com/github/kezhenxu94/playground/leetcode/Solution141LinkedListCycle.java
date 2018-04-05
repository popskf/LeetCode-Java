package com.github.kezhenxu94.playground.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. Linked List Cycle
 *
 * Given a linked list, determine if it has a cycle in it.
 *
 * Follow up:
 * Can you solve it without using extra space?
 *
 * TODO Optimize
 *
 * @author Ke Zhenxu kezhenxu94@163.com
 */
public class Solution141LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        while (head != null) {
            if (!set.add(head))
                return true;
            head = head.next;
        }
        return false;
    }
}
