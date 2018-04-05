package com.github.kezhenxu94.playground.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 *
 * Given a digit string, return all possible letter
 * combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the
 * telephone buttons) is given below.
 *
 * Input:Digit string "23"
 *
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * Note:
 * Although the above answer is in lexicographical order,
 * your answer could be in any order you want.
 *
 * [Tags] BackTracking
 *
 * TODO Optimize
 *
 * @author Ke Zhenxu
 */
public class Solution017LetterCombinationsOfAPhoneNumber {

    private static final char[][] digitsAlphas = {
            {},
            {}, {'a', 'b', 'c'}, {'d', 'e', 'f'},
            {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'},
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return result;
        backtracking(result, new char[digits.length()], 0, digits);
        return result;
    }

    private void backtracking(List<String> result, char[] temp, int track, String digits) {
        char[] alphaForI = digitsAlphas[digits.charAt(track) - '0'];
        for (int i = 0; i < alphaForI.length; i++) {
            temp[track] = alphaForI[i];
            if (track == digits.length() - 1) {
                result.add(new String(temp));
            } else {
                backtracking(result, temp, track + 1, digits);
            }
        }
    }
}
