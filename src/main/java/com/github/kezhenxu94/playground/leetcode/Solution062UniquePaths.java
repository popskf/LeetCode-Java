package com.github.kezhenxu94.playground.leetcode;

import java.util.Arrays;

/**
 * 62. Unique Paths
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 *
 * How many possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 *
 * @author ke.zhen.xu
 */
public class Solution062UniquePaths {

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(dp[i], 0);
        dp[m - 1][n - 1] = 0;
        dp[m - 1][n - 2] = 1;
        dp[m - 2][n - 1] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 < m) {
                    dp[i][j] += dp[i + 1][j];
                }
                if (j + 1 < n) {
                    dp[i][j] += dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}
