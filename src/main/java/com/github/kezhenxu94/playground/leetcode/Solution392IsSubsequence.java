package com.github.kezhenxu94.playground.leetcode;

/**
 * 392. Is Subsequence Given a string s and a string t, check if s is
 * subsequence of t.
 *
 * You may assume that there is only lower case English letters in both s and t.
 * t is potentially a very long (length ~= 500,000) string, and s is a short
 * string (<=100).
 *
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ace" is a
 * subsequence of "abcde" while "aec" is not).
 *
 * Example 1: s = "abc", t = "ahbgdc"
 *
 * Return true.
 *
 * Example 2: s = "axc", t = "ahbgdc"
 *
 * Return false.
 *
 * Follow up: If there are lots of incoming S, say S1, S2, ... , Sk where k >=
 * 1B, and you want to check one by one to see if T has its subsequence. In this
 * scenario, how would you change your code?
 *
 * [Tags] Dynamic Programming
 *
 * @author ke.zhen.xu
 */
public class Solution392IsSubsequence {

    /*
     * Memory Limit Exceeded
     */
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0)
            return true;
        if (s.length() == t.length())
            return s.equals(t);
        if (s.length() > t.length())
            return false;

        boolean[][] result = new boolean[s.length()][t.length()];
        result[0][0] = s.charAt(0) == t.charAt(0);
        for (int i = 1; i < t.length(); i++)
            result[0][i] = result[0][i - 1] || s.charAt(0) == t.charAt(i);

        for (int i = 1; i < s.length(); i++) {
            for (int j = i + 1; j < t.length(); j++) {
                result[i][j] = result[i][j - 1] || (result[i - 1][j - 1] && s.charAt(i) == t.charAt(j));
            }
        }
        return result[s.length() - 1][t.length() - 1];
    }

    /*
     * Time Limit Exceeded
     */
    public boolean isSubsequenceV2(String s, String t) {
        if (s.length() == 0)
            return true;
        return isSubsequenceHelper(s, s.length() - 1, t, t.length() - 1);
    }

    private boolean isSubsequenceHelper(String s, int index1, String t, int index2) {
        if (index1 == 0)
            return t.substring(0, index2 + 1).contains(s.substring(0, index1 + 1));
        if (index1 > index2)
            return false;
        return isSubsequenceHelper(s, index1, t, index2 - 1)
                || (isSubsequenceHelper(s, index1 - 1, t, index2 - 1) && s.charAt(index1) == t.charAt(index2));
    }

    public boolean isSubsequenceV3(String s, String t) {
        int indexOfS = 0;
        int indexOfT = 0;
        while (indexOfS < s.length() && indexOfT < t.length()) {
            if (s.charAt(indexOfS) == t.charAt(indexOfT))
                indexOfS++;
            indexOfT++;
        }
        return indexOfS == s.length() && indexOfT < t.length();
    }
}
