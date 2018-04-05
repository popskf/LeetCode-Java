package com.github.kezhenxu94.playground.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. Largest Divisible Subset
 *
 * Given a set of distinct positive integers, find the largest subset such that
 * every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj
 * % Si = 0.
 *
 * If there are multiple solutions, return any subset is fine.
 *
 * Example 1:
 *
 * nums: [1,2,3]
 *
 * Result: [1,2] (of course, [1,3] will also be ok)
 *
 * Example 2:
 *
 * nums: [1,2,4,8]
 *
 * Result: [1,2,4,8]
 *
 * @author ke.zhen.xu
 */
public class Solution368LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();
        if (nums.length == 1)
            return Arrays.asList(nums[0]);
        Arrays.sort(nums);
        int[] subsetSize = new int[nums.length];
        int[] prevIndex = new int[nums.length];
        Arrays.fill(prevIndex, -1);
        subsetSize[0] = 1;
        prevIndex[0] = -1;
        for (int i = 1; i < nums.length; i++) {
            int maxSubsetSize = 0;
            int maxIndex = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && subsetSize[j] + 1 > maxSubsetSize) {
                    maxSubsetSize = subsetSize[j] + 1;
                    maxIndex = j;
                }
            }
            subsetSize[i] = maxSubsetSize;
            prevIndex[i] = maxIndex;
        }
        int maxIndex = nums.length - 1;
        int maxSize = subsetSize[maxIndex];
        for (int j = maxIndex - 1; j >= 0; j--) {
            if (maxSize < subsetSize[j]) {
                maxIndex = j;
                maxSize = subsetSize[j];
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = maxIndex; i != -1; i = prevIndex[i])
            result.add(nums[i]);
        return result;
    }
}
