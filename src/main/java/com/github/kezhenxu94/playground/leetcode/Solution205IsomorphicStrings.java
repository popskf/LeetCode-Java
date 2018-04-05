package com.github.kezhenxu94.playground.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. Isomorphic Strings
 *
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced
 * to get t.
 *
 * All occurrences of a character must be replaced with another
 * character while preserving the order of characters.
 * No two characters may map to the same character
 * but a character may map to itself.
 *
 * For example,
 * Given "egg", "add", return true.
 *
 * Given "foo", "bar", return false.
 *
 * Given "paper", "title", return true.
 *
 * Note:
 * You may assume both s and t have the same length.
 *
 * @author ke.zhen.xu
 */
public class Solution205IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (map.containsKey(cs) && map.get(cs) != ct)
                return false;
            if (map.containsValue(ct) && map.getOrDefault(cs, '\0') != ct)
                return false;
            map.put(cs, ct);
        }
        return true;
    }
}
