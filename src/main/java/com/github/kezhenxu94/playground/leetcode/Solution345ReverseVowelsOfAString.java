package com.github.kezhenxu94.playground.leetcode;

/**
 * 345. Reverse Vowels of a String
 *
 * Write a function that takes a string as
 * input and reverse only the vowels of a string.
 *
 * Example 1:
 * Given s = "hello", return "holle".
 *
 * Example 2:
 * Given s = "com.github.kezhenxu94.playground.leetcode", return "leotcede".
 *
 * Note:
 * The vowels does not include the letter "y".
 *
 * @author KeZhenxu
 */
public class Solution345ReverseVowelsOfAString {

    public String reverseVowels(String s) {
        char[] charArray = s.toCharArray();
        for (int start = 0, end = charArray.length - 1; start < end; ) {
            while (charArray[start] != 'a' &&
                    charArray[start] != 'e' &&
                    charArray[start] != 'i' &&
                    charArray[start] != 'o' &&
                    charArray[start] != 'u' &&
                    charArray[start] != 'A' &&
                    charArray[start] != 'E' &&
                    charArray[start] != 'I' &&
                    charArray[start] != 'O' &&
                    charArray[start] != 'U' &&
                    start < end)
                start++;
            while (charArray[end] != 'a' &&
                    charArray[end] != 'e' &&
                    charArray[end] != 'i' &&
                    charArray[end] != 'o' &&
                    charArray[end] != 'u' &&
                    charArray[end] != 'A' &&
                    charArray[end] != 'E' &&
                    charArray[end] != 'I' &&
                    charArray[end] != 'O' &&
                    charArray[end] != 'U' &&
                    start < end)
                end--;
            if (start < end) {
                char temp = charArray[start];
                charArray[start] = charArray[end];
                charArray[end] = temp;
                start++;
                end--;
            } else {
                break;
            }
        }
        return new String(charArray);
    }
}
