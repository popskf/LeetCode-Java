package com.github.kezhenxu94.playground.leetcode;

import java.util.Arrays;
import java.util.BitSet;
import java.util.TreeSet;

/**
 * 264. Ugly Number II
 *
 * Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10
 * ugly numbers.
 *
 * Note that 1 is typically treated as an ugly number.
 *
 * TODO REDO
 *
 * [Tags] Dynamic Programming
 *
 * @author ke.zhen.xu
 */
public class Solution264UglyNumberII {

    /*
     * Memory Limit Exceeded
     *
     * Reason: Most numbers are not ugly.
     */
    public int nthUglyNumber(int n) {
        BitSet isUgly = new BitSet(n);
        isUgly.set(1);
        int i = isUgly.nextSetBit(0);
        for (int ith = 1; ith < n; ith++) {
            isUgly.set(i * 2);
            isUgly.set(i * 3);
            isUgly.set(i * 5);
            i = isUgly.nextSetBit(i + 1);
        }
        return i;
    }

    /**
     * Hint:
     *
     * The naive approach is to call isUgly for every number until you reach the
     * nth one. Most numbers are not ugly. Try to focus your effort on
     * generating only the ugly ones.
     *
     * An ugly number must be multiplied by either 2, 3, or 5 from a smaller
     * ugly number.
     *
     * The key is how to maintain the order of the ugly numbers. Try a similar
     * approach of merging from three sorted lists: L1, L2, and L3.
     *
     * Assume you have Uk, the kth ugly number. Then Uk+1 must be
     *
     * Min(L1 * 2, L2 * 3, L3 * 5).
     */
    public int nthUglyNumberV2(int n) {
        TreeSet<Long> queue = new TreeSet<>();
        queue.addAll(Arrays.asList(1L, 2L, 3L, 5L));
        for (int i = 0; i < n - 1; i++) {
            long min = queue.pollFirst();
            queue.add(min * 2);
            queue.add(min * 3);
            queue.add(min * 5);
        }
        return queue.pollFirst().intValue();
    }
}
