package com.github.kezhenxu94.playground.leetcode;

/**
 * 1. Two Sum
 *
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * UPDATE (2016/2/13):
 * The return format had been changed to zero-based indices. Please read the
 * above updated description carefully.
 *
 * @author ke.zhen.xu
 */
public class Solution001TwoSum {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{j, i};
                }
            }
        }
        return null;
    }
}
