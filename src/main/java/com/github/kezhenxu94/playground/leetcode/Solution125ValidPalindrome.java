package com.github.kezhenxu94.playground.leetcode;

/**
 * 125. Valid Palindrome
 *
 * <pre>
 *
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 *
 * For example, "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 *
 * Note: Have you consider that the string might be empty? This is a good
 * question to ask during an interview.
 *
 * For the purpose of this problem, we define empty string as valid palindrome.
 *
 * </pre>
 *
 * @author ke.zhen.xu
 */
public class Solution125ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty())
            return true;

        char[] charArray = s.toCharArray();
        int start = 0;
        int end = charArray.length - 1;
        while (!isAlphanumeric(charArray[start]) && start < end)
            start++;
        while (!isAlphanumeric(charArray[end]) && start < end)
            end--;

        while (start < end) {
            if (Character.toUpperCase(charArray[start]) != Character.toUpperCase(charArray[end]))
                return false;
            start++;
            end--;
            while (!isAlphanumeric(charArray[start]) && start < end)
                start++;
            while (!isAlphanumeric(charArray[end]) && start < end)
                end--;
        }
        return true;
    }

    private boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
}
