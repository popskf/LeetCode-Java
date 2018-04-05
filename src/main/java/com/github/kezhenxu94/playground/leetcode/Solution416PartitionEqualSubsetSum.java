package com.github.kezhenxu94.playground.leetcode;

import java.util.Arrays;

/**
 * 416. Partition Equal Subset Sum
 *
 * Given a non-empty array containing only positive integers, find if the array
 * can be partitioned into two subsets such that the sum of elements in both
 * subsets is equal.
 *
 * Note: Both the array size and each of the array element will not exceed 100.
 *
 * Example 1:
 *
 * Input: [1, 5, 11, 5]
 *
 * Output: true
 *
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 * Example 2:
 *
 * Input: [1, 2, 3, 5]
 *
 * Output: false
 *
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 * @author ke.zhen.xu
 */
public class Solution416PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 == 1)
            return false;
        return backtracking(nums, 0, sum, 0);
    }

    private static boolean[] choices = {true, false};

    private boolean backtracking(int[] nums, int sumSoFar, int sum, int k) {
        boolean result = false;
        for (boolean choice : choices) {
            if (choice) {
                sumSoFar += nums[k];
            } else {
                sumSoFar -= nums[k];
            }

            if (sumSoFar == sum / 2)
                return true;
            if (k + 1 == nums.length || sumSoFar > sum / 2)
                return false;
            result |= backtracking(nums, sumSoFar, sum, k + 1);
            if (result)
                return result;
        }
        return result;
    }
}