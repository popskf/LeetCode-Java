package com.github.kezhenxu94.playground.leetcode;

/**
 * 58. Length of Last Word
 *
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 *
 * For example, Given s = "Hello World", return 5.
 *
 * @author ke.zhen.xu
 */
public class Solution058LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if (s == null)
            return 0;
        String[] words = s.trim().split("\\s+");
        return words[words.length - 1].length();
    }

    public int lengthOfLastWordV2(String s) {
        if (s == null || s.isEmpty())
            return 0;

        char[] charArray = s.toCharArray();
        int last = charArray.length - 1;
        while (last >= 0 && charArray[last] == ' ')
            last--;
        if (last < 0)
            return 0;
        int first = last - 1;
        while (first >= 0 && charArray[first] != ' ')
            first--;
        return last - first;
    }
}
