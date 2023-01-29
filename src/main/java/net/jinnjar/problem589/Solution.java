package net.jinnjar.problem589;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adnan
 * @since 10/22/2023
 */
public class Solution {

    public List<Integer> preorder(Node root) {
        List<Integer> nodeValues = new ArrayList<>();

        iteratePreorder(nodeValues, root);

        return nodeValues;
    }

    private void iteratePreorder(List<Integer> nodeValues, Node currentNode) {
        if (currentNode == null) return;

        nodeValues.add(currentNode.val);

        for (Node childNode: currentNode.children) {
            iteratePreorder(nodeValues, childNode);
        }
    }
}


class Node {

    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
