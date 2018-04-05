package com.github.kezhenxu94.playground.leetcode;

/**
 * 377. Combination Sum IV
 *
 * Given an integer array with all positive numbers and no duplicates, find the
 * number of possible combinations that add up to a positive integer target.
 *
 * Example:
 *
 * nums = [1, 2, 3] target = 4
 *
 * The possible combination ways are:
 *
 * (1, 1, 1, 1)
 *
 * (1, 1, 2)
 *
 * (1, 2, 1)
 *
 * (1, 3)
 *
 * (2, 1, 1)
 *
 * (2, 2)
 *
 * (3, 1)
 *
 * Note that different sequences are counted as different combinations.
 *
 * Therefore the output is 7.
 *
 * Follow up: What if negative numbers are allowed in the given array?
 *
 * How does it change the problem?
 *
 * What limitation we need to add to the question to allow negative numbers?
 *
 * @author ke.zhen.xu
 */
public class Solution377CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] dp = new int[target + 1];
        for (int i = 0; i < nums[0] && i < target; i++)
            dp[i] = 0;
        for (int i = 1; i <= target; i++) {
            for (int j = nums.length - 1; j >= 0; j--) {
                if (i > nums[j])
                    dp[i] += dp[i - nums[j]];
                else if (i == nums[j])
                    dp[i]++;
            }
        }
        return dp[target];
    }
}
