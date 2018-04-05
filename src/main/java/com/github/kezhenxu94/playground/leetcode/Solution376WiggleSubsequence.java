package com.github.kezhenxu94.playground.leetcode;

/**
 * <pre>
 *
 * 376. Wiggle Subsequence
 *
 * A sequence of numbers is called a wiggle sequence if the differences between
 * successive numbers strictly alternate between positive and negative. The
 * first difference (if one exists) may be either positive or negative. A
 * sequence with fewer than two elements is trivially a wiggle sequence.
 *
 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences
 * (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5]
 * and [1,7,4,5,5] are not wiggle sequences, the first because its first two
 * differences are positive and the second because its last difference is zero.
 *
 * Given a sequence of integers, return the length of the longest subsequence
 * that is a wiggle sequence. A subsequence is obtained by deleting some number
 * of elements (eventually, also zero) from the original sequence, leaving the
 * remaining elements in their original order.
 *
 * Examples:
 *
 * Input: [1,7,4,9,2,5]
 * Output: 6
 * The entire sequence is a wiggle sequence.
 *
 * Input: [1,17,5,10,13,15,10,5,16,8]
 * Output: 7
 * There are several subsequences that achieve this length. One is
 * [1,17,10,13,10,16,8].
 *
 * Input: [1,2,3,4,5,6,7,8,9]
 * Output: 2
 *
 * Follow up:
 * Can you do it in O(n) time?
 *
 * </pre>
 *
 * TODO Refactor
 *
 * @author ke.zhen.xu
 */
public class Solution376WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;

        int[] count = new int[nums.length];        // the maximum count when the index reach subscript i
        int[] sign = new int[nums.length];        // the sign of nums[i] - nums[previous] when the count reach maximum in subarray nums[0...i]
        count[0] = 1;
        count[1] = nums[1] == nums[0] ? 1 : 2;
        sign[1] = nums[1] == nums[0] ? 0 : (nums[1] > nums[0] ? 1 : -1);
        for (int i = 2; i < count.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (sign[j] == 0) {
                    if (count[i] < (1 + (nums[i] == nums[j] ? 0 : 1))) {        // if nums[i] is the first different number, +1, otherwise +0
                        count[i] = 1 + (nums[i] == nums[j] ? 0 : 1);
                        sign[i] = nums[i] - nums[j];
                    }
                } else if ((nums[i] - nums[j]) * sign[j] < 0) {                    // nums[i] can be added to the subarray
                    if (count[i] < count[j] + 1) {
                        count[i] = count[j] + 1;
                        sign[i] = nums[i] - nums[j];
                    }
                } else if ((nums[i] - nums[j]) * sign[j] == 0) {                // nums[i] is the same as nums[j], the maximum count of nums[0...i] is the bigger one between that of nums[0...j] and that of nums[0...i]
                    if (count[i] < count[i - 1]) {
                        count[i] = count[i - 1];
                        sign[i] = nums[i] - nums[j];
                    }
                }
            }
        }
        return count[count.length - 1];
    }
}
