package com.github.kezhenxu94.playground.leetcode;

/**
 * <pre>
 *
 * 405. Convert a Number to Hexadecimal
 *
 * Given an integer, write an algorithm to convert it to hexadecimal. For
 * negative integer, two’s complement method is used.
 *
 * Note:
 *
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s. If the number is
 * zero, it is represented by a single zero character '0'; otherwise, the
 * first character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed
 * integer.
 *
 * You must not use any method provided by the library which converts/formats
 * the number to hex directly.
 *
 * Example 1:
 *
 * Input:
 * 26
 *
 * Output:
 * "1a"
 * Example 2:
 *
 * Input:
 * -1
 *
 * Output:
 * "ffffffff"
 *
 * </pre>
 *
 * @author KeZhenxu
 */
public class Solution405ConvertANumberToHexadecimal {

    private static final char[] digits = "0123456789abcdef".toCharArray();

    public String toHex(int num) {
        StringBuilder result = new StringBuilder();
        int i = 28;
        while (i > 0 && ((num & (0xf << i)) >>> i) == 0)
            i -= 4;
        for (; i >= 0; i -= 4)
            result.append(digits[(num & (0xf << i)) >>> i]);
        return result.toString();
    }
}
