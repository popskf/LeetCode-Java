package com.github.kezhenxu94.playground.leetcode;

/**
 * 258. Add Digits
 *
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * For example:
 *
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 *
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 */
public class Solution258AddDigits {

    public int addDigits(int num) {
        if (num < 10)
            return num;
        int sum = 0;
        for (int r = num; r > 0; r = r / 10)
            sum += r % 10;
        return addDigits(sum);
    }

    /*
     *
     * Forum solution
     *
     * public int addDigits(int num) { return (num != 0 && num % 9 == 0) ? 9 : num % 9; }
     *
     */
}
