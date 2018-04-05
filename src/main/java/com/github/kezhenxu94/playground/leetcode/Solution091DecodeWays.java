package com.github.kezhenxu94.playground.leetcode;

/**
 * 91. Decode Ways
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 *
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 *
 * The number of ways decoding "12" is 2.
 *
 * @author Ke Zhenxu
 */
public class Solution091DecodeWays {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        if (s.charAt(0) == '0')
            return 0;
        if (s.length() == 1)
            return 1;

        char[] sa = s.toCharArray();
        int[] dp = new int[sa.length];
        dp[0] = sa[0] == '0' ? 0 : 1;
        if (sa[1] == '0') {
            if (sa[0] == '1' || sa[0] == '2')
                dp[1] = 1;
        } else if (sa[0] == '1' || (sa[0] == '2' && sa[1] <= '6'))
            dp[1] = 2;
        else
            dp[1] = 1;

        for (int i = 2; i < sa.length; i++) {
            if (sa[i] == '0') {
                if (sa[i - 1] == '1' || sa[i - 1] == '2')
                    dp[i] = dp[i - 2];
                else
                    dp[i] = 0;
            } else if (sa[i - 1] == '1' || (sa[i - 1] == '2' && sa[i] <= '6'))
                dp[i] = dp[i - 1] + dp[i - 2];
            else
                dp[i] = dp[i - 1];
        }
        return dp[s.length() - 1];
    }
}
