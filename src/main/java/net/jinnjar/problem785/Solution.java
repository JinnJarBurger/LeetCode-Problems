package net.jinnjar.problem785;

/**
 * @author adnan
 * @since 5/19/2023
 */
public class Solution {

    public boolean isBipartite(int[][] graph) {
        // Solution 1 (Fastest, Worst Space Complexity)
        int[] visited = new int[graph.length]; // red -> 1, blue -> -1

        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0 && isNotValid(graph, visited, 1, i)) return false;
        }

        return true;
    }

    public boolean isNotValid(int[][] graph, int[] visited, int prevColor, int parentNode) {
        if (visited[parentNode] != 0) return visited[parentNode] != prevColor;

        visited[parentNode] = prevColor;

        for (int i : graph[parentNode]) {
            if (isNotValid(graph, visited, -prevColor, i)) return true;
        }

        return false;
    }
}
