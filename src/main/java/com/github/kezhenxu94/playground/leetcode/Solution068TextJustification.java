package com.github.kezhenxu94.playground.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *
 * 68. Text Justification
 *
 *  Given an array of words and a length L, format the text such that each line
 *  has exactly L characters and is fully (left and right) justified.
 *
 *  You should pack your words in a greedy approach; that is, pack as many words
 *  as you can in each line. Pad extra spaces ' ' when necessary so that each
 *  line has exactly L characters.
 *
 *  Extra spaces between words should be distributed as evenly as possible. If
 *  the number of spaces on a line do not divide evenly between words, the
 *  empty slots on the left will be assigned more spaces than the slots on the
 *  right.
 *
 *  For the last line of text, it should be left justified and no extra space
 *  is inserted between words.
 *
 *  For example,
 *  words: ["This", "is", "an", "example", "of", "text", "justification."]
 *  L: 16.
 *
 *  Return the formatted lines as:
 *
 *  [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 *  ]
 *
 * Note: Each word is guaranteed not to exceed L in length.
 *
 * </pre>
 *
 * TODO unfinished
 *
 * @author KeZhenxu
 */
public class Solution068TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (int wordIndexAtLineStart = 0, wordIndexAtLineEnd = 0, width = 0;
             wordIndexAtLineEnd < words.length;
             wordIndexAtLineEnd++, wordIndexAtLineStart = wordIndexAtLineEnd, width = 0) {

            sb.delete(0, sb.length());
            while (wordIndexAtLineEnd < words.length && width + words[wordIndexAtLineEnd].length() <= maxWidth) {
                width += words[wordIndexAtLineEnd].length() + 1;    // a space
                wordIndexAtLineEnd++;
            }
            wordIndexAtLineEnd--;        // go back a word

            int averageSpaces = maxWidth - width;
            int extraSpacesCount = 0;    // number of words that has extra space
            if (wordIndexAtLineEnd > wordIndexAtLineStart) {
                averageSpaces = (maxWidth - width) / (wordIndexAtLineEnd - wordIndexAtLineStart) + 1;
                extraSpacesCount = (maxWidth - width) % (wordIndexAtLineEnd - wordIndexAtLineStart);
            }
            for (int i = wordIndexAtLineStart; i <= wordIndexAtLineEnd; i++) {
                sb.append(words[i]);
                for (int j = 0; j < averageSpaces; j++)
                    sb.append(" ");
                if (i - wordIndexAtLineStart <= extraSpacesCount)
                    sb.append(" ");
            }
            result.add(sb.toString());
        }
        return result;
    }
}
