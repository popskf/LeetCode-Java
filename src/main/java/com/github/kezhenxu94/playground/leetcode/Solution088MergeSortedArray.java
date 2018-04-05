package com.github.kezhenxu94.playground.leetcode;

/**
 * 88. Merge Sorted Array
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1
 * as one sorted array.
 *
 * Note:
 * You may assume that nums1 has enough space (size that is greater or
 * equal to m + n) to hold additional elements from nums2. The number of
 * elements initialized in nums1 and nums2 are m and n respectively.
 *
 * @author ke.zhen.xu
 */
public class Solution088MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0)
            return;
        int i = m + n - 1;
        --n;
        --m;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n])
                nums1[i--] = nums1[m--];
            else
                nums1[i--] = nums2[n--];
        }
        while (m >= 0)
            nums1[i--] = nums1[m--];
        while (n >= 0)
            nums1[i--] = nums2[n--];
    }
}
