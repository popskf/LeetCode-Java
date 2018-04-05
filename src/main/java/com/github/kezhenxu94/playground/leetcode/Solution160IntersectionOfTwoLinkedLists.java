package com.github.kezhenxu94.playground.leetcode;

/**
 * 160. Intersection of Two Linked Lists
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 *
 * For example, the following two linked lists:
 *
 * A:          a1 → a2
 * ↘
 * c1 → c2 → c3
 * ↗
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 *
 * Notes:
 *
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 *
 * @author ke.zhen.xu
 */
public class Solution160IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeOfA = 0;
        int sizeOfB = 0;
        for (ListNode pa = headA; pa != null; pa = pa.next)
            sizeOfA++;
        for (ListNode pb = headB; pb != null; pb = pb.next)
            sizeOfB++;
        if (sizeOfA > sizeOfB)
            for (int i = 0; i < sizeOfA - sizeOfB; i++)
                headA = headA.next;
        if (sizeOfB > sizeOfA)
            for (int i = 0; i < sizeOfB - sizeOfA; i++)
                headB = headB.next;
        return intersect(headA, headB);
    }

    /**
     * You must ensure that list A and list B has the same length
     * before calling the method
     */
    private ListNode intersect(ListNode headA, ListNode headB) {
        while (headA != null && headB != null) {
            if (headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
