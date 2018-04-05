package com.github.kezhenxu94.playground.leetcode;

/**
 * 53. Maximum Subarray
 *
 * Find the contiguous subarray within an array (containing at least one
 * number) which has the largest sum.
 *
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 *
 * @author ke.zhen.xu
 */
public class Solution053MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < nums.length; i++)
            result = Math.max(result, dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]));

        return result;
    }
}
