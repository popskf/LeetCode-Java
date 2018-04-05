package com.github.kezhenxu94.playground.leetcode;

/**
 * 137. Single Number II
 *
 * Given an array of integers, every element appears three times except for
 * one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 *
 * @author ke.zhen.xu
 */
public class Solution137SingleNumberII {

    public int singleNumber(int[] nums) {
        int[] bitCount = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bitCount[i] += ((num >> i) & 1);
            }
        }

        int result = 0;
        for (int i = 0; i < 32; i++)
            if (bitCount[i] % 3 == 1)
                result += (1 << i);
        return result;
    }
}
