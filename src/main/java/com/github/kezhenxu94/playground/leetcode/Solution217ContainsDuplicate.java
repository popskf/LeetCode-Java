package com.github.kezhenxu94.playground.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. Contains Duplicate
 *
 * Given an array of integers, find if the array contains any duplicates. Your
 * function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 */
public class Solution217ContainsDuplicate {

    /**
     * Time Limit Exceeded
     *
     * TODO Optimize
     *
     * @param nums
     * @return true if there is any value appears at least twice in the array,
     * false otherwise
     */
    public boolean containsDuplicateV1(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums)
            if (set.contains(num))
                return true;
            else
                set.add(num);
        return false;
    }
}
