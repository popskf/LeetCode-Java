package com.github.kezhenxu94.playground.leetcode;

/**
 * 279. Perfect Squares
 *
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13,
 * return 2 because 13 = 4 + 9.
 *
 * [Tags] Dynamic Programming
 *
 * @author ke.zhen.xu
 */
public class Solution279PerfectSquares {

    // TODO Optimize
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++)
            dp[i] = i;

        for (int i = 1; i <= n; i++) {
            int m = 0;
            for (int j = m * m; j <= i; j = m * m) {
                if (isPower(i - j))
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                else
                    dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
                m++;
            }
        }
        return dp[n];
    }

    private boolean isPower(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}
