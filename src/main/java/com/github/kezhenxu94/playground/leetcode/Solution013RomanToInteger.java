package com.github.kezhenxu94.playground.leetcode;

/**
 * 13. Roman to Integer
 *
 * Given a roman numeral, convert it to an integer.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * @author ke.zhen.xu
 */
public class Solution013RomanToInteger {

    public int romanToInt(String s) {
        if (s == null || s.isEmpty())
            return 0;

        char[] charArray = s.toCharArray();
        int numBehind = romanToInt(charArray[charArray.length - 1]);
        int result = numBehind;
        for (int i = charArray.length - 2; i >= 0; i--) {
            int thisNum = romanToInt(charArray[i]);
            if (numBehind > thisNum)
                result -= thisNum;
            else
                result += thisNum;
            numBehind = thisNum;
        }
        return result;
    }

    private int romanToInt(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
