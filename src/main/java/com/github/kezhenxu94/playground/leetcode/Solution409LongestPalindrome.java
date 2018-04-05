package com.github.kezhenxu94.playground.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 409. Longest Palindrome
 *
 * Given a string which consists of lowercase or uppercase letters, find the
 * length of the longest palindromes that can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Note: Assume the length of given string will not exceed 1,010.
 *
 * Example:
 *
 * Input: "abccccdd"
 *
 * Output: 7
 *
 * Explanation: One longest palindrome that can be built is "dccaccd", whose
 * length is 7.
 *
 * @author ke.zhen.xu
 */
public class Solution409LongestPalindrome {

    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i))) {
                result += 2;
                set.remove(s.charAt(i));
            }
        }
        return result + (set.isEmpty() ? 0 : 1);
    }
}
