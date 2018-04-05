package com.github.kezhenxu94.playground.leetcode;

/**
 * 300. Longest Increasing Subsequence
 *
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 *
 * For example, Given [10, 9, 2, 5, 3, 7, 101, 18], The longest increasing
 * subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may
 * be more than one LIS combination, it is only necessary for you to return the
 * length.
 *
 * Your algorithm should run in O(n2) complexity.
 *
 * Follow up: Could you improve it to O(n log n) time complexity?
 *
 * [Tags] Dynamic Programming
 *
 * @author ke.zhen.xu
 */
public class Solution300LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++)
            dp[i] = 1;

        for (int i = 1; i < nums.length; i++)
            for (int j = i - 1; j >= 0; j--)
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;

        int max = dp[0];
        for (int i = 1; i < dp.length; i++)
            if (dp[i] > max)
                max = dp[i];

        return max;
    }
}
