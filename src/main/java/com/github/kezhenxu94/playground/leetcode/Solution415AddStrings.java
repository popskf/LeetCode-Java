package com.github.kezhenxu94.playground.leetcode;

/**
 * 415. Add Strings
 *
 * Given two non-negative numbers num1 and num2 represented as string, return
 * the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 *
 * Both num1 and num2 contains only digits 0-9.
 *
 * Both num1 and num2 does not contain any leading zero.
 *
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 *
 * @author ke.zhen.xu
 */
public class Solution415AddStrings {

    public String addStrings(String num1, String num2) {
        char[] result = new char[Math.max(num1.length(), num2.length()) + 1];
        int carrier = 0;
        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;
        int k = result.length - 1;
        while (i1 >= 0 && i2 >= 0) {
            int sum = (num1.charAt(i1) - '0') + (num2.charAt(i2) - '0') + carrier;
            carrier = sum / 10;
            result[k--] = (char) (sum % 10 + '0');
            i1--;
            i2--;
        }
        while (i1 >= 0) {
            int sum = (num1.charAt(i1) - '0') + carrier;
            carrier = sum / 10;
            result[k--] = (char) (sum % 10 + '0');
            i1--;
        }
        while (i2 >= 0) {
            int sum = (num2.charAt(i2) - '0') + carrier;
            carrier = sum / 10;
            result[k--] = (char) (sum % 10 + '0');
            i2--;
        }
        result[k] = (char) (carrier + '0');
        int from = 0;
        while (from < result.length - 1 && (result[from] == '\0' || result[from] == '0'))
            from++;
        return new String(result, from, result.length - from);
    }
}