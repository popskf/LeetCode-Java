package com.github.kezhenxu94.playground.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 102. Binary Tree Level Order Traversa
 *
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 *
 * For example: Given binary tree [3,9,20,null,null,15,7],
 *
 * <pre>
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its level order traversal as:
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * </pre>
 *
 * @author ke.zhen.xu
 */
public class Solution102BinaryTreeLevelOrderTraversa {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null)
            levelOrderHelper(result, root, 1);
        return result;
    }

    private void levelOrderHelper(List<List<Integer>> result, TreeNode node, int depth) {
        if (depth > result.size()) // The first node of this level
            result.add(new ArrayList<>()); // Create a list for this level

        List<Integer> level = result.get(depth - 1);
        level.add(node.val);

        depth++;

        if (node.left != null)
            levelOrderHelper(result, node.left, depth);

        if (node.right != null)
            levelOrderHelper(result, node.right, depth);
    }
}
