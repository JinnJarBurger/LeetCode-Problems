package net.jinnjar.problem103;

import net.jinnjar.common.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author adnan
 * @since 2/19/2023
 */
public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new LinkedList<>();

        if (root == null) {
            return answer;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        int index = 0;
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {
            List<Integer> leftRightVal = new ArrayList<>();
            int size = nodeQueue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = nodeQueue.poll();

                leftRightVal.add(node.val);

                if (node.right != null) nodeQueue.offer(node.right);
                if (node.left != null) nodeQueue.offer(node.left);
            }

            if (index % 2 == 0) {
                List<Integer> reverse = new LinkedList<>();
                for (int i = leftRightVal.size() - 1; i >= 0; i--) {
                    reverse.add(leftRightVal.get(i));
                }

                answer.add(reverse);
            } else {
                answer.add(leftRightVal);
            }

            index++;
        }

        return answer;
    }
}
