package com.github.kezhenxu94.playground.leetcode;

import org.junit.Test;

public class TestSolution151ReverseWordsInAString {

    @Test
    public void testSolution151ReverseWordsInAString() {
        Solution151ReverseWordsInAString sol = new Solution151ReverseWordsInAString();
        System.out.println(sol.reverseWords(""));
        System.out.println(sol.reverseWords("I"));
        System.out.println(sol.reverseWords("I am a student"));
        System.out.println(sol.reverseWords("I  am  a student"));
    }
}
