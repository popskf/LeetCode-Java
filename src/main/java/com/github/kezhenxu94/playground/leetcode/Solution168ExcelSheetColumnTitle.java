package com.github.kezhenxu94.playground.leetcode;

/**
 * 168. Excel Sheet Column Title
 *
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 *
 * For example:
 *
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 *
 * @author Ke Zhenxu
 */
public class Solution168ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        char[] table = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n -= 1;
            sb.insert(0, table[n % 26]);
            n /= 26;
        }
        return sb.toString();
    }
}
