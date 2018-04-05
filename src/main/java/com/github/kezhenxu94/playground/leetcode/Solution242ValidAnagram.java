package com.github.kezhenxu94.playground.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242. Valid Anagram
 *
 * Given two strings s and t, write a function to determine if t is an anagram
 * of s.
 *
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 *
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your
 * solution to such case?
 */
public class Solution242ValidAnagram {

    /**
     * 38ms
     */
    public boolean isAnagramV1(String s, String t) {
        Map<Character, Integer> charCount = new HashMap<Character, Integer>();
        for (char c : s.toCharArray())
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        for (char c : t.toCharArray())
            charCount.put(c, charCount.getOrDefault(c, 0) - 1);
        for (int count : charCount.values())
            if (count != 0)
                return false;
        return true;
    }

    /**
     * 4ms
     */
    public boolean isAnagramV2(String s, String t) {
        int[] charCount = new int[26];
        Arrays.fill(charCount, 0);

        for (char c : s.toCharArray())
            charCount[c - 'a']++;
        for (char c : t.toCharArray())
            charCount[c - 'a']--;
        for (int num : charCount)
            if (num != 0)
                return false;
        return true;
    }
}
