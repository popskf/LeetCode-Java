package com.github.kezhenxu94.playground.leetcode;

import java.util.Random;

/**
 * <pre>
 *
 * 382. Linked List Random Node
 *
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
 *
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?
 *
 * Example:
 *
 * // Init a singly linked list [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 *
 * // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 * // solution.getRandom();
 * //
 *
 * </pre>
 *
 * @author Ke Zhenxu
 */
public class Solution382LinkedListRandomNode {

    class Solution {
        Random random = new Random();
        int length = 1;
        ListNode p;

        /**
         * @param head The linked list's head.
         *             Note that the head is guaranteed to be not null, so it contains at least one node.
         */
        public Solution(ListNode head) {
            p = head;
            while (p.next != null) {
                p = p.next;
                length++;
            }
            p.next = head;
        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {
            int rand = random.nextInt(length);
            while (rand-- >= 0)
                p = p.next;
            return p.val;
        }
    }
}
