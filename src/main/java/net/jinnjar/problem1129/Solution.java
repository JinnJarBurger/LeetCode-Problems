package net.jinnjar.problem1129;

import net.jinnjar.common.Pair;

import java.util.*;

/**
 * @author adnan
 * @since 2/11/2023
 */
public class Solution {

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<Pair>> adjMatrix = new HashMap<>();

        Arrays.stream(redEdges).forEach(redEdge -> adjMatrix.computeIfAbsent(redEdge[0], l -> new ArrayList<>()).add(new Pair(redEdge[1], 0)));
        Arrays.stream(blueEdges).forEach(blueEdge -> adjMatrix.computeIfAbsent(blueEdge[0], l -> new ArrayList<>()).add(new Pair(blueEdge[1], 1)));

        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        answer[0] = 0;
        boolean[][] visited = new boolean[n][2];
        Queue<List<Object>> queue = new LinkedList<>();

        queue.add(List.of(0, 0, -1));
        visited[0][0] = visited[0][1] = true;

        while (!queue.isEmpty()) {
            List<Object> element = queue.remove();
            int node = (int) element.get(0);
            int steps = (int) element.get(1);
            int prevColor = (int) element.get(2);

            if (!adjMatrix.containsKey(node)) {
                continue;
            }

            adjMatrix.get(node).forEach(pair -> {
                int neighbour = pair.firstVal;
                int color = pair.secondVal;

                if (!visited[neighbour][color] && color != prevColor) {
                    if (answer[neighbour] == -1) {
                        answer[neighbour] = steps + 1;
                    }

                    visited[neighbour][color] = true;
                    queue.add(List.of(neighbour, steps + 1, color));
                }
            });
        }

        return answer;
    }
}

