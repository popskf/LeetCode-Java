package com.github.kezhenxu94.playground.leetcode;

import org.junit.Test;

public class TestSolution058LengthOfLastWord {

    @Test
    public void testSolution058LengthOfLastWord() {
        Solution058LengthOfLastWord sol = new Solution058LengthOfLastWord();
        assert sol.lengthOfLastWord("Hello world") == 5;
        assert sol.lengthOfLastWord("") == 0;
        assert sol.lengthOfLastWord("   ") == 0;
        assert sol.lengthOfLastWordV2("Hello world") == 5;
        assert sol.lengthOfLastWordV2("") == 0;
        assert sol.lengthOfLastWordV2("   ") == 0;
    }
}
