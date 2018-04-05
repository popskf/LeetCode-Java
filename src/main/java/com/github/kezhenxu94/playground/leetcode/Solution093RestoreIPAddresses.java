package com.github.kezhenxu94.playground.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *
 * 93. Restore IP Addresses
 *
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * For example:
 * Given "25525511135",
 *
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 *
 * </pre>
 *
 * TODU unfinished
 *
 * @author Ke Zhenxu
 */
public class Solution093RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtracking(s, new boolean[11], result, 0, 0);
        return result;
    }

    private void backtracking(String s, boolean[] dots, List<String> result, int k, int from) {
        for (int i = from; i < Math.min(3 + from, s.length()); i++) {
            dots[i] = true;
            if (Integer.valueOf(s.substring(from, i)) < 256) {
                if (k == 3) {

                }
                dots[i] = false;
            }
        }
    }
}
