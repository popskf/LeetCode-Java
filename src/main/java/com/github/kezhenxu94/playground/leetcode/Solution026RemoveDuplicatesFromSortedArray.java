package com.github.kezhenxu94.playground.leetcode;

/**
 * 26. Remove Duplicates from Sorted Array
 *
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 *
 * For example, Given input array nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively. It doesn't matter what you leave beyond the new
 * length.
 *
 * @author ke.zhen.xu
 */
public class Solution026RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int lastNonRepeatIndex = 0;
        for (int start = lastNonRepeatIndex + 1; start < nums.length; start++) {
            while (start < nums.length && nums[start] == nums[lastNonRepeatIndex])
                start++;
            if (start < nums.length)
                swap(nums, start, ++lastNonRepeatIndex);
        }
        return lastNonRepeatIndex + 1;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
