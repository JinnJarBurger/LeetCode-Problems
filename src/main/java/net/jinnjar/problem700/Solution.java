package net.jinnjar.problem700;

import net.jinnjar.common.tree.TreeNode;

/**
 * adnan
 * 2/7/2024
 */
public class Solution {

    TreeNode subTree = null;

    public TreeNode searchBST(TreeNode root, int val) {
        traverse(root, val);

        return subTree;
    }

    private void traverse(TreeNode node, int val) {
        if (node == null) return;

        if (node.val == val) {
            subTree = node;
            return;
        }

        traverse(node.left, val);
        traverse(node.right, val);
    }
}
