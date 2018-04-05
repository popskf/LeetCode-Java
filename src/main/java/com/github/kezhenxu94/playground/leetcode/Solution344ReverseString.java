package com.github.kezhenxu94.playground.leetcode;

/**
 * 344. Reverse String
 *
 * Write a function that takes a string as input and returns the string reversed.
 *
 * Example:
 * Given s = "hello", return "olleh".
 */
public class Solution344ReverseString {

    public String reverseString(String s) {
        char[] charArray = s.toCharArray();
        char temp;
        int len = charArray.length;
        for (int idx = 0; idx < len / 2; idx++) {
            temp = charArray[idx];
            charArray[idx] = charArray[len - idx - 1];
            charArray[len - idx - 1] = temp;
        }
        return new String(charArray);
    }
}
