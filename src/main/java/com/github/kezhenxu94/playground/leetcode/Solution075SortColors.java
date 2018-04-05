package com.github.kezhenxu94.playground.leetcode;

/**
 * Created by kid on 2018/4/4.
 *
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 *
 * @author kezhenxu (kezhenxu94 at 163 dot com)
 */
public class Solution075SortColors {
    class Solution {
        public void sortColors(int[] nums) {
            int length = nums.length;

            int pointerDividingRW = 0, pointerDividingWB = nums.length - 1;

            while (pointerDividingRW < length && nums[pointerDividingRW] == 0) {
                pointerDividingRW++;
            }
            while (pointerDividingWB > pointerDividingRW && nums[pointerDividingWB] == 2) {
                pointerDividingWB--;
            }

            //     pointerDividingRW         i           pointerDividingWB
            //             │                 │                   │
            // │<--- 0 --->│<------ 1 ------>│<---- unsorted --->│<--- 2 --->│
            // ├──────────────────────────────────────────┤
            // elements whose indices in [0, pointerDividingRW) are 0
            // elements whose indices in [pointerDividingRW, i) are 1
            // elements whose indices in [i, pointerDividingWB] are undetermined
            // elements whose indices in (pointerDividingWB, length - 1] are 2
            for (int i = pointerDividingRW; i <= pointerDividingWB && pointerDividingRW < pointerDividingWB; i++) {
                switch (nums[i]) {
                    case 0:
                        swap(nums, i, pointerDividingRW);
                        pointerDividingRW++;
                        break;
                    case 2:
                        swap(nums, i, pointerDividingWB);
                        pointerDividingWB--;
                        // Go back one step because nums[pointerDividingWB], which is swapped to nums[i], is undetermined
                        i--;
                        break;
                }
            }
        }

        private void swap(int[] nums, int x, int y) {
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
        }
    }
}
