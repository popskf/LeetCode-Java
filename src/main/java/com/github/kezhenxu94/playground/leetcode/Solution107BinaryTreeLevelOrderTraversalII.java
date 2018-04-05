package com.github.kezhenxu94.playground.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 107. Binary Tree Level Order Traversal II
 *
 * <pre>
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes'
 * values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its bottom-up level order traversal as:
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * </pre>
 *
 * @author ke.zhen.xu
 */
public class Solution107BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottomV1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> parentLevel = new ArrayList<>();
        List<TreeNode> thisLevel = new ArrayList<>();
        if (root != null)
            parentLevel.add(root);
        while (!parentLevel.isEmpty()) {
            thisLevel.clear();
            List<Integer> valueList = new ArrayList<>();
            for (TreeNode node : parentLevel) {
                if (node != null) {
                    valueList.add(node.val);
                    if (node.left != null)
                        thisLevel.add(node.left);
                    if (node.right != null)
                        thisLevel.add(node.right);
                }
            }
            parentLevel.clear();
            parentLevel.addAll(thisLevel);
            result.add(0, valueList);
        }
        return result;
    }

    public List<List<Integer>> levelOrderBottomV2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        treeWalkThrough(result, root, 1);
        Collections.reverse(result);
        return result;
    }

    private void treeWalkThrough(List<List<Integer>> result, TreeNode node, int depth) {
        if (node != null) {
            if (result.size() < depth) // it is the first node of this level
                result.add(new ArrayList<>());

            result.get(depth - 1).add(node.val);

            depth++;
            treeWalkThrough(result, node.left, depth);
            treeWalkThrough(result, node.right, depth);
        }
    }
}
