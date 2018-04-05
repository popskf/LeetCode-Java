package com.github.kezhenxu94.playground.leetcode;

/**
 * 10. Regular Expression Matching
 *
 * <pre>
 *
 * Implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character. '*' Matches zero or more of the preceding
 * element.
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 *
 *  Some examples:
 *  isMatch("aa","a") → false
 *  isMatch("aa","aa") → true
 *  isMatch("aaa","aa") → false
 *  isMatch("aa", "a*") → true
 *  isMatch("aa", ".*") → true
 *  isMatch("ab", ".*") → true
 *  isMatch("aab", "c*a*b") → true
 *
 * </pre>
 *
 * TODO Unfinished
 *
 * [Tags] Dynamic Programming
 *
 * @author ke.zhen.xu
 */
public class Solution010RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        boolean[][] result = new boolean[p.length() + 1][s.length() + 1];
        result[0][0] = true;
        for (int i = 2; i <= p.length(); i += 2)
            result[i][0] = result[i - 2][0] && p.charAt(i - 1) == '*';

        return result[p.length()][s.length()];
    }
}
