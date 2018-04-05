package com.github.kezhenxu94.playground.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 *
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 */
public class Solution169MajorityElement {

    public int majorityElementV1(int[] nums) {
        Map<Integer, Integer> numCounts = new HashMap<Integer, Integer>();
        for (int num : nums)
            numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
        for (Map.Entry<Integer, Integer> entry : numCounts.entrySet())
            if (entry.getValue() > nums.length / 2)
                return entry.getKey();
        return 0;
    }

    /**
     * TODO explanation
     */
    public int majorityElementV2(int[] nums) {
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (major == nums[i])
                count++;
            else if (count == 0)
                major = nums[i];
            else
                count--;
        }
        return major;
    }
}
