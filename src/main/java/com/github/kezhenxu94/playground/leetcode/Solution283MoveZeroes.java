package com.github.kezhenxu94.playground.leetcode;

/**
 * 283. Move Zeroes
 *
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 *
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function,
 * nums should be [1, 3, 12, 0, 0].
 *
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class Solution283MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums == null)
            return;

        int nonZero = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[nonZero++] = nums[i];
        }
        while (nonZero < nums.length)
            nums[nonZero++] = 0;
    }
}
