package com.github.kezhenxu94.playground.leetcode;

/**
 * 342. Power of Four
 *
 * Given an integer (signed 32 bits), write a function to check whether it is a
 * power of 4.
 *
 * Example: Given num = 16, return true. Given num = 5, return false.
 *
 * Follow up: Could you solve it without loops/recursion?
 *
 * @author Ke Zhenxu
 */
public class Solution342PowerOfFour {

    public boolean isPowerOfFour(int num) {
        if (num < 1)
            return false;

        while ((num & 3) == 0)
            num >>= 2;
        return num == 1;
    }
}
