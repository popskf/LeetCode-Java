package com.github.kezhenxu94.playground.leetcode;

import java.util.BitSet;

/**
 * <pre>
 *
 * 313. Super Ugly Number
 *
 * Write a program to find the nth super ugly number.
 *
 * Super ugly numbers are positive numbers whose all prime factors are in the
 * given prime list primes of size k.
 *
 * For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of
 * the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.
 *
 * Note:
 * (1) 1 is a super ugly number for any given primes.
 * (2) The given numbers in primes are in ascending order.
 * (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 *
 * </pre>
 *
 * TODU unfinished
 *
 * @author ke.zhen.xu
 */
public class Solution313SuperUglyNumber {

    // May Memory Limit Exceeded when n is large (100000)
    public int nthSuperUglyNumber(int n, int[] primes) {
        BitSet bs = new BitSet();
        bs.set(1);
        int count = 1;
        int result = 1;
        while (count < n) {
            for (int num : primes) {
                int temp = result * num;
                bs.set(temp);
            }
            result = bs.nextSetBit(result + 1);
            count++;
        }
        return result;
    }
}
