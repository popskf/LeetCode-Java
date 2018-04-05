package com.github.kezhenxu94.playground.leetcode;

import java.util.Arrays;

/**
 * 387. First Unique Character in a String
 *
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "com.github.kezhenxu94.playground.leetcode" return 0.
 *
 * s = "loveleetcode", return 2.
 *
 * Note: You may assume the string contain only lowercase letters.
 *
 * @author ke.zhen.xu
 */
public class Solution387FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        int[] charCounts = new int[26];
        Arrays.fill(charCounts, 0);

        for (char c : s.toCharArray())
            charCounts[c - 'a']++;

        for (int i = 0; i < s.length(); i++)
            if (charCounts[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}
