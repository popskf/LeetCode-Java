package com.github.kezhenxu94.playground.leetcode;

import java.util.Arrays;

/**
 * Created by kid on 2018/3/31.
 * <p>
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * @author kezhenxu (kezhenxu94 at 163 dot com)
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class Solution016ThreeSumClosest {
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            return v2(nums, target);
        }

        // Inspired by two sum
        private int v2(int[] nums, int target) {
            if (nums.length <= 3) return Arrays.stream(nums).sum();

            Arrays.sort(nums);

            int result = nums[0] + nums[1] + nums[2];
            int smallestDiff = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length - 2; i++) {
                int j = i + 1, k = nums.length - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == target) {
                        return target;
                    }
                    int diff = Math.abs(sum - target);
                    if (diff < smallestDiff) {
                        smallestDiff = diff;
                        result = sum;
                    }
                    if (sum > target) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }

            return result;
        }

        // Naive for loop
        private int v1(int[] nums, int target) {
            if (nums.length <= 3) return Arrays.stream(nums).sum();

            int result = nums[0] + nums[1] + nums[2];
            int smallestDiff = Integer.MAX_VALUE;
            for (int i = 2; i < nums.length; i++) {
                for (int j = 1; j < i; j++) {
                    for (int k = 0; k < j; k++) {
                        int sum = nums[i] + nums[j] + nums[k];
                        int diff = Math.abs(sum - target);
                        if (diff < smallestDiff) {
                            result = sum;
                            smallestDiff = diff;
                        }
                    }
                }
            }

            return result;
        }

        // Below are backtrace solution, but failed to be accepted because of SOE
        private int threeSumClosest(int index0, int index1, int index2, int[] nums, int target) {
            int sum = nums[index0] + nums[index1] + nums[index2];

            if (sum >= target) return sum;

            if (index0 + 1 < index1)
                return threeSumClosest(index0 + 1, index1, index2, nums, target);
            else if (index1 + 1 < index2)
                return threeSumClosest(0, index1 + 1, index2, nums, target);
            else if (index2 + 1 < nums.length)
                return threeSumClosest(0, 1, index2 + 1, nums, target);
            else return sum;
        }

        // Tail recursion try to resolve SOE
        private int threeSumClosest2(int index0, int index1, int index2, int[] nums, int target) {
            int sum = nums[index0] + nums[index1] + nums[index2];

            if (sum >= target) return sum;

            if (index0 + 1 < index1)
                return threeSumClosest2(index0 + 1, index1, index2, nums, target);
            else if (index1 + 1 < index2)
                return threeSumClosest2(0, index1 + 1, index2, nums, target);
            else return sum;
        }

        // Becoming pure for loop ~_~;
        private int threeSumClosest3(int index0, int index1, int index2, int[] nums, int target) {
            int sum = nums[index0] + nums[index1] + nums[index2];

            if (sum >= target) return sum;

            if (index0 + 1 < index1)
                return threeSumClosest3(index0 + 1, index1, index2, nums, target);

            return sum;
        }
    }
}
