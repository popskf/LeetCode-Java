package com.github.kezhenxu94.playground.leetcode;

/**
 * 70. Climbing Stairs
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 *
 * @author Ke Zhenxu
 */
public class Solution070ClimbingStairs {

    public int climbStairsRecursive(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
    }

    public int climbStairsIterative(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        int nMinus2 = 1;
        int nMinus1 = 2;

        n -= 2;
        while (--n > 0) {
            int temp = nMinus1 + nMinus2;
            nMinus2 = nMinus1;
            nMinus1 = temp;
        }

        return nMinus1 + nMinus2;
    }
}
