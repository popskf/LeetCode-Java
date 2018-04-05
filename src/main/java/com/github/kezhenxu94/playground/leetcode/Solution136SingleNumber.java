package com.github.kezhenxu94.playground.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 136. Single Number
 *
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Solution136SingleNumber {

    public int singleNumber(int[] nums) {
        Map<Integer, Boolean> appeared = new HashMap<Integer, Boolean>();
        for (int num : nums)
            if (appeared.containsKey(num))
                appeared.remove(num);
            else
                appeared.put(num, true);
        return appeared.keySet().iterator().next();
    }

    public int singleNumberV2(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++)
            result ^= nums[i];
        return result;
    }

}
