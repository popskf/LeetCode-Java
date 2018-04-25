package com.github.kezhenxu94.playground.leetcode;

import java.util.Stack;

/**
 * Created by kid on 2018/4/25.
 *
 * Given an absolute path for a file (Unix-style), simplify it.
 *
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 *
 * @author kezhenxu (kezhenxu94 at 163 dot com)
 */
public class Solution071SimplifyPath {
    class Solution {
        public String simplifyPath(String path) {
            return v1(path);
        }

        private String v1(final String path) {
            final Stack<String> stack = new Stack<>();

            for (String segment : path.split("/")) {
                segment = segment.trim();

                if (segment.isEmpty() || segment.equals("."))
                    continue;

                if (segment.equals("..")) {
                    if (!stack.isEmpty())
                        stack.pop();
                    continue;
                }

                stack.push(segment);
            }

            final java.util.StringJoiner stringJoiner = new java.util.StringJoiner("/", "/", "");

            for (String s : stack)
                stringJoiner.add(s);

            return stringJoiner.toString();
        }
    }
}
