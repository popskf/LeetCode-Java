package com.github.kezhenxu94.playground.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. Palindrome Linked List
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class Solution234PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;

        List<Integer> sb = new ArrayList<>();
        for (ListNode p = head; p != null; p = p.next)
            sb.add(p.val);

        for (int i = 0, j = sb.size() - 1; i < j; i++, j--)
            if (sb.get(i).intValue() != sb.get(j).intValue())
                return false;
        return true;
    }
}
