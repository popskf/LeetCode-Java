package com.github.kezhenxu94.playground.leetcode;

import java.util.Stack;

/**
 * 104. Maximum Depth of Binary Tree
 *
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along
 * the longest path from the root node down to the farthest leaf node.
 */
public class Solution104MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return maxDepthHelper(root, 1);
    }

    /**
     * Naive Method: Recursion
     */
    private int maxDepthHelper(TreeNode root, int depth) {
        if (root == null)
            return depth;
        if (root.left == null && root.right == null)
            return depth;
        depth++;
        int left = maxDepthHelper(root.left, depth);
        int right = maxDepthHelper(root.right, depth);
        return left > right ? left : right;
    }

    /**
     * Iterative, slower than recursion
     */
    @SuppressWarnings("unused")
    private int maxDepthHelperTail(TreeNode root) {
        int max = 0;
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<Integer> depthStack = new Stack<Integer>();
        nodeStack.push(root);
        depthStack.push(1);
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();
            if (depth > max)
                max = depth;

            if (node.left != null) {
                nodeStack.push(node.left);
                depthStack.push(depth + 1);
            }

            if (node.right != null) {
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
            }
        }
        return max;
    }
}
