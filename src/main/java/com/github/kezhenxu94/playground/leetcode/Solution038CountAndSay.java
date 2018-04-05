package com.github.kezhenxu94.playground.leetcode;

/**
 * 38. Count and Say
 *
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 *
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
 * off as "one 2, then one 1" or 1211.
 *
 * Given an integer n, generate the nth sequence.
 *
 * Note: The sequence of integers will be represented as a string.
 *
 * @author ke.zhen.xu
 */
public class Solution038CountAndSay {

    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String last = "1";
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            sb.delete(0, sb.length());
            for (int j = 0; j < last.length(); j++) {
                int count = 1;
                while (j + 1 < last.length() && last.charAt(j) == last.charAt(j + 1)) {
                    count++;
                    j++;
                }
                sb.append(count).append(last.charAt(j));
            }
            last = sb.toString();
        }
        return sb.toString();
    }
}
