package com.github.kezhenxu94.playground.leetcode;

/**
 * Created by kid on 2018/4/6.
 *
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 *
 * @author kezhenxu (kezhenxu94 at 163 dot com)
 */
@SuppressWarnings("WeakerAccess")
public class Solution209MinimumSizeSubarraySum {
    class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            return v1(s, nums);
        }

        //       i                  j
        // |     |<-- sum >= s ---->|
        // |-----|------------------|--------|
        private int v1(int s, int[] nums) {
            int length = nums.length;

            if (length == 0) {
                return 0;
            }

            int minLength = Integer.MAX_VALUE;

            int i = 0, j = 0;
            int sum1 = 0, sum2 = 0;

            do {
                while (j < length && sum2 - sum1 < s) {
                    sum2 += nums[j];
                    j++;
                }
                if (sum2 - sum1 >= s)
                    minLength = Math.min(minLength, j - i);

                while (sum2 - sum1 >= s) {
                    sum1 += nums[i];
                    minLength = Math.min(minLength, j - i);
                    i++;
                }

                if (minLength == 1) { // Fast success
                    return 1;
                }
            } while (j < length);

            return minLength == Integer.MAX_VALUE ? 0 : minLength;
        }
    }
}
