package com.github.kezhenxu94.playground.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 *
 * Given a string, find the length of the longest substring without repeating
 * characters.
 *
 * Examples:
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * Given "bbbbb", the answer is "b", with the length of 1.
 *
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * @author ke.zhen.xu
 */
@SuppressWarnings("WeakerAccess")
public class Solution003LongestSubstringWithoutRepeatingCharacters {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            return v1(s.toCharArray());
        }

        public int v1(char[] chars) {
            if (chars.length == 0)
                return 0;

            int maxLength = 0;

            Map<Character, Integer> charactersSeen = new HashMap<>();

            for (int i = 0; i < chars.length; i++) {
                if (!charactersSeen.containsKey(chars[i])) {
                    charactersSeen.put(chars[i], i);
                    continue;
                }
                maxLength = Math.max(maxLength, charactersSeen.size());

                i = charactersSeen.get(chars[i]);

                charactersSeen.clear();
            }

            maxLength = Math.max(maxLength, charactersSeen.size());

            return maxLength;
        }
    }
}
