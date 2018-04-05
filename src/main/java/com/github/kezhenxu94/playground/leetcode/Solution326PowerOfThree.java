package com.github.kezhenxu94.playground.leetcode;

/**
 * 326. Power of Three
 *
 * Given an integer, write a function to determine if it is a power of three.
 *
 * @author Ke Zhenxu
 */
public class Solution326PowerOfThree {

    public boolean isPowerOfThree(int n) {
        if (n < 1)
            return false;
        while (n % 3 == 0)
            n /= 3;
        return n == 1;
    }

}
