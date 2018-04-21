package com.github.kezhenxu94.playground.leetcode;

import java.util.BitSet;

/**
 * Created by kid on 2018/4/21.
 *
 * 318. Maximum Product of Word Lengths
 *
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j])
 * where the two words do not share common letters. You may assume that each word will contain only lower case letters.
 * If no such two words exist, return 0.
 *
 * Example 1:
 * Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 * Return 16
 * The two words can be "abcw", "xtfn".
 *
 * Example 2:
 * Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 * Return 4
 * The two words can be "ab", "cd".
 *
 * Example 3:
 * Given ["a", "aa", "aaa", "aaaa"]
 * Return 0
 * No such pair of words.
 *
 * @author kezhenxu (kezhenxu94 at 163 dot com)
 */
public class Solution318MaximumProductOfWordLengths {
    class Solution {
        public int maxProduct(String[] words) {
            return v1(words);
        }

        private int v1(String[] words) {
            final BitSet[] bitSets = new BitSet[words.length];
            for (int i = 0; i < words.length; i++) {
                bitSets[i] = new BitSet(words[i].length());
                for (int j = 0; j < words[i].length(); j++) {
                    bitSets[i].set(words[i].charAt(j) - 'a');
                }
            }

            int result = 0;
            for (int i = 0; i < bitSets.length - 1; i++) {
                for (int j = i + 1; j < bitSets.length; j++) {
                    BitSet b = (BitSet) bitSets[i].clone();
                    b.and(bitSets[j]);
                    if (b.isEmpty()) {
                        int p = words[i].length() * words[j].length();
                        result = Math.max(p, result);
                    }
                }
            }
            return result;
        }
    }
}
