package com.github.kezhenxu94.playground.leetcode;

import java.util.LinkedList;

/**
 * <pre>
 *
 * 390. Elimination Game
 *
 * There is a list of sorted integers from 1 to n. Starting from left
 * to right, remove the first number and every other number afterward
 * until you reach the end of the list.
 *
 * Repeat the previous step again, but this time from right to left,
 * remove the right most number and every other number from the
 * remaining numbers.
 *
 * We keep repeating the steps again, alternating left to right and
 * right to left, until a single number remains.
 *
 * Find the last number that remains starting with a list of length n.
 *
 * Example:
 *
 * Input:
 * n = 9,
 * 1 2 3 4 5 6 7 8 9
 * 2 4 6 8
 * 2 6
 * 6
 *
 * Output:
 * 6
 *
 * </pre>
 *
 * TODU unfinished
 *
 * @author Ke Zhenxu
 */
public class Solution390EliminationGame {

    // Time Limit Exceeded
    public int lastRemaining(int n) {
        LinkedList<Integer> s1 = new LinkedList<>();
        LinkedList<Integer> s2 = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            s1.addFirst(i);
        while (s1.size() > 1) {
            while (!s1.isEmpty()) {
                s1.removeLast();
                if (!s1.isEmpty())
                    s2.addLast(s1.removeLast());
            }
            LinkedList<Integer> temp = s1;
            s1 = s2;
            s2 = temp;
        }
        return s1.removeLast();
    }

    public int lastRemainingV2(int n) {
        return 0;
    }
}
