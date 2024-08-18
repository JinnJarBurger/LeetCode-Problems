package net.jinnjar.problem572;

import net.jinnjar.common.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * adnan
 * 8/18/2024
 */
public class Solution {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.val == subRoot.val && isSameSubTree(node, subRoot)) return true;

            if (node.left != null) queue.add(node.left);

            if (node.right != null) queue.add(node.right);
        }

        return false;
    }

    private boolean isSameSubTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;

        if (p == null || q == null) return false;

        if (p.val != q.val) return false;

        return isSameSubTree(p.left, q.left) && isSameSubTree(p.right, q.right);
    }
}
