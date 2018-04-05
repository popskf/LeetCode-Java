package com.github.kezhenxu94.playground.leetcode;

/**
 * <pre>
 *
 * 151. Reverse Words in a String
 *
 * Given an input string, reverse the string word by word.
 *
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 *
 * Update (2015-02-12):
 * For C programmers: Try to solve it in-place in O(1) space.
 *
 * </pre>
 *
 * @author kezhenxu
 */
public class Solution151ReverseWordsInAString {

    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--)
            result.append(words[i]).append(" ");
        return result.toString().trim();
    }
}
