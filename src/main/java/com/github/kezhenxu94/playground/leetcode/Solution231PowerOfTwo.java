package com.github.kezhenxu94.playground.leetcode;

/**
 * 231. Power of Two
 *
 * Given an integer, write a function to determine if it is a power of two.
 *
 * @author Ke Zhenxu
 */
public class Solution231PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n < 1)
            return false;
        while ((n & 1) != 1)
            n >>= 1;
        return n == 1;
    }

    /**
     * Since the power of 2 in binary system looks like:
     *
     * 1, 10, 100, 1000, 10000, ...,
     *
     * minus 1 becomes:
     *
     * 0, 01, 011, 0111, 01111, ...,
     *
     * use and operator it will be 0
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwoV2(int n) {
        return (n != 0) && ((n & (n - 1)) == 0);
    }
}
