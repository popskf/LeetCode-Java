package com.github.kezhenxu94.playground.leetcode;

import java.util.Arrays;

/**
 * 66. Plus One
 *
 * Given a non-negative number represented as an array of digits, plus one to
 * the number.
 *
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 *
 * @author Ke Zhenxu
 */
public class Solution066PlusOne {

    public int[] plusOne(int[] digits) {
        boolean hasCarry = true;
        for (int n : digits) {
            if (n != 9) {
                hasCarry = false;
                break;
            }
        }

        if (hasCarry) {
            int[] result = new int[digits.length + 1];
            Arrays.fill(result, 0);
            result[0] = 1;
            return result;
        }

        int[] result = new int[digits.length];
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            carry = sum > 9 ? 1 : 0;
            result[i] = sum % 10;
        }
        return result;
    }
}
