package com.github.kezhenxu94.playground.leetcode;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 *
 * Example:
 * Given a = 1 and b = 2, return 3.
 */
public class Solution371SumOfTwoIntegers {

    public int getSum(int a, int b) {
        int partial1 = a ^ b;
        int partial2 = ((a & b) << 1);
        if (partial1 == 0)
            return partial2;
        if (partial2 == 0)
            return partial1;
        return getSum(partial1, partial2);
    }
}
