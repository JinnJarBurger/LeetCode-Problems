package net.jinnjar.problem783;

import net.jinnjar.common.tree.TreeNode;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * @author adnan
 * @since 2/17/2023
 */
public class Solution {

    private int minDistance;

    private TreeNode prevNode;

    public int minDiffInBST(TreeNode root) {
        minDistance = Integer.MAX_VALUE;

        inOrderTraversal(root);

        return minDistance;
    }

    private void inOrderTraversal(TreeNode node) {
        if (isNull(node)) {
            return;
        }

        inOrderTraversal(node.left);

        if (nonNull(prevNode)) {
            minDistance = Math.min(minDistance, node.val - prevNode.val);
        }

        prevNode = node;

        inOrderTraversal(node.right);
    }
}
