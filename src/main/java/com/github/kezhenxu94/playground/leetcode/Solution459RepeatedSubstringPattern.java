package com.github.kezhenxu94.playground.leetcode;

/**
 * <pre>
 *
 * 459. Repeated Substring Pattern My SubmissionsBack To Contest Given a
 * non-empty string check if it can be constructed by taking a substring of it
 * and appending multiple copies of the substring together. You may assume the
 * given string consists of lowercase English letters only and its length will
 * not exceed 10000.
 *
 * Example 1:
 *
 * Input: "abab"
 *
 * Output: True
 *
 * Explanation: It's the substring "ab" twice.
 *
 * Example 2:
 *
 * Input: "aba"
 *
 * Output: False
 *
 * Example 3:
 *
 * Input: "abcabcabcabc"
 *
 * Output: True
 *
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc"
 * twice.)
 *
 * </pre>
 *
 * TODO unfinished
 *
 * @author kezhenxu
 */
public class Solution459RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String str) {
        int len = str.length();
        char lastChar = str.charAt(len - 1);
        int substringStartIndex = str.indexOf(lastChar, len / 2 - 1) + 1;
        while (true) {
            if (substringStartIndex >= len || substringStartIndex < 0)
                return false;
            if (canBeRepeated(str, str.substring(substringStartIndex, len)))
                return true;
            substringStartIndex = str.indexOf(lastChar, substringStartIndex + 1);
        }
    }

    private boolean canBeRepeated(String str, String substr) {
        if (str.equals(substr))
            return true;
        return str.startsWith(substr) && canBeRepeated(str.substring(substr.length()), substr);
    }
}
