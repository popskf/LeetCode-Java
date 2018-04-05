package com.github.kezhenxu94.playground.leetcode;

/**
 * 189. Rotate Array
 *
 * Rotate an array of n elements to the right by k steps.
 *
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to
 * [5,6,7,1,2,3,4].
 *
 * Note: Try to come up as many solutions as you can, there are at least 3
 * different ways to solve this problem.
 *
 * @author Ke Zhenxu
 */
public class Solution189RotateArray {

    /**
     * Naive method TLE
     *
     * @param nums
     * @param k
     */
    public void rotateV1(int[] nums, int k) {
        k %= nums.length;
        if (k == 0)
            return;
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    public void rotateV2(int[] nums, int k) {
        int len = nums.length;
        if ((k %= len) == 0)
            return;

        // copy the first k elements
        int[] temp = new int[k];
        for (int i = 0; i < k; i++)
            temp[i] = nums[i];

        /* Rotate the remaining elements,
         * To avoid overriding the element that
         * has not yet been rotated to its final position,
         * I start from right to left
         */
        for (int i = len - 1; i >= k; i--)
            nums[(i + k) % len] = nums[i];

        /*
         * Rotate the first k elements
         */
        for (int i = 0; i < k; i++)
            nums[(i + k) % len] = temp[i];
    }
}
