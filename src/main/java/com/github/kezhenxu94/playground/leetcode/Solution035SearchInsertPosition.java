package com.github.kezhenxu94.playground.leetcode;

/**
 * 35. Search Insert Position
 *
 * Given a sorted array and a target value, return the index
 * if the target is found. If not, return the index
 * where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 *
 * @author Ke Zhenxu
 */
public class Solution035SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;
        for (mid = (lo + hi) / 2; lo <= hi; mid = (lo + hi) / 2) {
            if (nums[mid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        if (nums[mid] > target)
            return mid > 0 ? mid - 1 : 0;
        if (nums[mid] < target)
            return mid + 1;
        return mid;
    }

}
