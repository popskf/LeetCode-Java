package com.github.kezhenxu94.playground.leetcode;

/**
 * 357. Count Numbers with Unique Digits
 *
 * Given a non-negative integer n, count all numbers with unique digits, x,
 * where 0 ≤ x < 10n.
 *
 * Example:
 * Given n = 2, return 91. (The answer should be the total numbers in the range
 * of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
 *
 * @author ke.zhen.xu
 */
public class Solution357CountNumbersWithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        if (n < 1)
            return 1;
        if (n == 1)
            return 10;
        int[] repeat = new int[n + 1];        // array repeat denotes only the non-unique digits from 10^(i-1) to 10^i
        int[] unique = new int[n + 1];
        repeat[1] = 0;
        unique[1] = 10;
        repeat[2] = 9;
        unique[2] = 81;
        int result = unique[1] + unique[2];
        // be careful that it may overflow when calculating 10 to the power (i - 1)
        for (int i = 3; i < n + 1; i++) {
            repeat[i] = repeat[i - 1] * 10 + unique[i - 1] * (i - 1);
            unique[i] = (int) (9 * Math.pow(10, i - 1)) - repeat[i];
            result += unique[i];
        }
        return result;
    }
}
