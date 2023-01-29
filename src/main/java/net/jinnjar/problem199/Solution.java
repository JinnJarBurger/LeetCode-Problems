package net.jinnjar.problem199;

import net.jinnjar.common.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * adnan
 * 3/13/2024
 */
public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        int qLength;
        TreeNode rightMostNode = root;

        List<Integer> answer = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            qLength = queue.size();

            for (int i = 0; i < qLength; i++) {
                rightMostNode = queue.poll();

                if (rightMostNode == null) break;

                if (rightMostNode.left != null) queue.add(rightMostNode.left);
                if (rightMostNode.right != null) queue.add(rightMostNode.right);
            }

            if (rightMostNode != null) answer.add(rightMostNode.val);
        }

        return answer;
    }
}
