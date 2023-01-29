package net.jinnjar.problem1557;

import java.util.LinkedList;
import java.util.List;

/**
 * @author adnan
 * @since 5/18/2023
 */
public class Solution {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // Solution 1 (Very Fast, Good Space Efficient)
        boolean[] visited = new boolean[n];

        for (List<Integer> edge : edges) {
            visited[edge.get(1)] = true;
        }

        List<Integer> ans = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) ans.add(i);
        }

        return ans;
    }
}
