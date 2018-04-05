package com.github.kezhenxu94.playground.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. Binary Tree Inorder Traversal
 *
 * <pre>
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree [1,null,2,3],
 *
 *    1
 *     \
 *       2
 *      /
 *     3
 *
 * return [1,3,2].
 *
 * Note: Recursive solution is trivial, could you do it
 * iteratively?
 *
 * </pre>
 *
 * @author ke.zhen.xu
 */
public class Solution094BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();
        for (TreeNode node = root; node != null; node = node.left)
            stack.addLast(node);

        while (!stack.isEmpty()) {
            TreeNode subRoot = stack.removeLast();
            result.add(subRoot.val);
            subRoot = subRoot.right;
            if (subRoot != null) {
                stack.addLast(subRoot);
                for (TreeNode node = subRoot.left; node != null; node = node.left)
                    stack.addLast(node);
            }
        }
        return result;
    }
}
