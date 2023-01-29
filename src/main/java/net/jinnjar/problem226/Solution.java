package net.jinnjar.problem226;

import net.jinnjar.common.tree.TreeNode;

import static java.util.Objects.isNull;

/**
 * @author adnan
 * @since 2/18/2023
 */
public class Solution {

    public TreeNode invertTree(TreeNode root) {
        reverseTree(root);

        return root;
    }

    private void reverseTree(TreeNode node) {
        if (isNull(node)) {
            return;
        }

        reverseTree(node.left);
        reverseTree(node.right);

        TreeNode tempNode = node.left;

        node.left = node.right;
        node.right = tempNode;
    }
}
