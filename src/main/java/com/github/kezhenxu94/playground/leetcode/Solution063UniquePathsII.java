package com.github.kezhenxu94.playground.leetcode;

import java.util.Arrays;

/**
 * 63. Unique Paths II
 *
 * Follow up for "Unique Paths":
 *
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * For example,
 *
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 *
 * [ [0,0,0], [0,1,0], [0,0,0] ]
 *
 * The total number of unique paths is 2.
 *
 * Note: m and n will be at most 100.
 *
 * @author ke.zhen.xu
 */
public class Solution063UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (m == 1) {
            for (int i = 0; i < n; i++)
                if (obstacleGrid[0][i] == 1)
                    return 0;
            return 1;
        }
        if (n == 1) {
            for (int i = 0; i < m; i++)
                if (obstacleGrid[i][0] == 1)
                    return 0;
            return 1;
        }

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(dp[i], 0);
        dp[m - 1][n - 1] = obstacleGrid[m - 1][n - 1] == 1 ? 0 : 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
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
