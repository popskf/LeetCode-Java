package com.github.kezhenxu94.playground.leetcode;

/**
 * 268. Missing Number
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find
 * the one that is missing from the array.
 *
 * For example, Given nums = [0, 1, 3] return 2.
 *
 * Note: Your algorithm should run in linear runtime complexity. Could you
 * implement it using only constant extra space complexity?
 *
 * @author ke.zhen.xu
 */
public class Solution268MissingNumber {

    public int missingNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++)
            result ^= i ^ nums[i];
        return result ^ nums.length;
    }
}
