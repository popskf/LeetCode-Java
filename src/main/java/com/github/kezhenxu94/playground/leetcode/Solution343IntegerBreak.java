package com.github.kezhenxu94.playground.leetcode;

/**
 * 343. Integer Break
 *
 * Given a positive integer n, break it into the sum of at least two
 * positive integers and maximize the product of those integers.
 * Return the maximum product you can get.
 *
 * For example, given n = 2, return 1 (2 = 1 + 1);
 * given n = 10, return 36 (10 = 3 + 3 + 4).
 *
 * Note: You may assume that n is not less than 2 and not larger than 58.
 *
 * [Tags] Dynamic Programming
 *
 * @author Ke Zhenxu
 */
public class Solution343IntegerBreak {

    public int integerBreak(int n) {
        /*
         * dp: the index of the first dimension denotes the number to be broken (10 in the given example)
         *	   the index of the second dimension denotes the number of first part
         */
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++)
            dp[i] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = i;
            dp[i][i] = 1;    // all divisions are all 1s
        }
        for (int i = 2; i <= n; i++)
            for (int j = 2; j <= i; j++)
                for (int k = 1; k < i; k++)
                    dp[i][j] = Math.max(dp[i][j], k * dp[i - k][j - 1]);

        int result = 0;
        for (int i = 2; i <= n; i++)
            result = Math.max(result, dp[n][i]);
        return result;
    }
}
