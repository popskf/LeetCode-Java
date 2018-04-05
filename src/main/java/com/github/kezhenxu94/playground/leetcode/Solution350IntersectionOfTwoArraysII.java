package com.github.kezhenxu94.playground.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 350. Intersection of Two Arrays II
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 *
 * Note:
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 *
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited
 * such that you cannot load all elements into the memory at once?
 *
 * TODO Optimize and the follow up
 */
public class Solution350IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> numCount = new HashMap<Integer, Integer>();
        for (int num : nums1)
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        List<Integer> result = new ArrayList<Integer>();
        for (int num : nums2) {
            if (numCount.getOrDefault(num, -1) > 0) {
                result.add(num);
                numCount.put(num, numCount.get(num) - 1);
            }
        }
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < resultArray.length; i++)
            resultArray[i] = result.get(i);
        return resultArray;
    }
}
