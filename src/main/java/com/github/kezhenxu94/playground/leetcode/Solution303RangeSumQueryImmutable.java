package com.github.kezhenxu94.playground.leetcode;

/**
 * 303. Range Sum Query - Immutable
 *
 * Given an integer array nums, find the sum of the elements between indices i
 * and j (i ≤ j), inclusive.
 *
 * Example:
 *
 * Given nums = [-2, 0, 3, -5, 2, -1]
 *
 * sumRange(0, 2) -> 1
 *
 * sumRange(2, 5) -> -1
 *
 * sumRange(0, 5) -> -3
 *
 * Note:
 *
 * You may assume that the array does not change.
 *
 * There are many calls to sumRange function.
 *
 *
 * [Tags] Dynamic Programming
 *
 * @author ke.zhen.xu
 */
public class Solution303RangeSumQueryImmutable {
    class NumArray {

        private Integer[] dp;
        private int[] nums;
        private boolean emptyNums;

        public NumArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                emptyNums = true;
                return;
            }
            this.nums = nums;
            dp = new Integer[nums.length];
            dp[0] = nums[0];
        }

        public int sumRange(int i, int j) {
            if (emptyNums)
                return 0;
            if (i == j)
                return nums[i];
            if (i > j)
                return 0;
            if (i == 0) {
                if (dp[j] != null)
                    return dp[j];
                int sum = 0;
                for (int idx = 0; idx <= j; idx++) {
                    sum += nums[idx];
                }
                dp[j] = sum;
                return dp[j];
            }
            return sumRange(0, j) - sumRange(0, i - 1);
        }
    }

}
