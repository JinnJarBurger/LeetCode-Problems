package net.jinnjar.problem104;

import net.jinnjar.common.tree.TreeNode;

import static java.util.Objects.isNull;

/**
 * @author adnan
 * @since 2/17/2023
 */
public class Solution {

    public int maxDepth(TreeNode root) {
        if (isNull(root)) {
            return 0;
        }

        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}
