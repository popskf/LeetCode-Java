package com.github.kezhenxu94.playground.leetcode;

/**
 * 27. Remove Element
 *
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 *
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 *
 * Example: Given input array nums = [3,2,2,3], val = 3
 *
 * Your function should return length = 2, with the first two elements of nums
 * being 2.
 *
 * @author Ke Zhenxu
 */
public class Solution027RemoveElement {

    public int removeElement(int[] nums, int val) {
        int lastNoValIndex = nums.length - 1;
        while (lastNoValIndex > 0 && nums[lastNoValIndex] == val)
            lastNoValIndex--;

        for (int i = 0; i < lastNoValIndex; i++) {
            if (nums[i] == val) {
                nums[i] = nums[lastNoValIndex];
                while (lastNoValIndex > 0 && nums[lastNoValIndex] == val)
                    lastNoValIndex--;
            }
        }
        return lastNoValIndex + 1;
    }
}
