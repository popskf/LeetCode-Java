package com.github.kezhenxu94.playground.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *
 * 257. Binary Tree Paths
 *
 * Given a binary tree, return all root-to-leaf paths.
 *
 * For example, given the following binary tree:
 *
 *   1
 *  / \
 * 2   3
 *  \
 *   5
 *
 * All root-to-leaf paths are:
 *
 * ["1->2->5", "1->3"]
 *
 * </pre>
 *
 * @author ke.zhen.xu
 */
public class Solution257BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null)
            return result;
        String pathSoFar = String.valueOf(root.val);
        explore(result, pathSoFar, root);
        return result;
    }

    private void explore(List<String> result, String pathSoFar, TreeNode node) {
        if (node.left != null)
            explore(result, pathSoFar + "->" + node.left.val, node.left);
        if (node.right != null)
            explore(result, pathSoFar + "->" + node.right.val, node.right);
        if (node.left == null && node.right == null)
            result.add(pathSoFar);
    }
}