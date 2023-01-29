package net.jinnjar.problem934;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author adnan
 * @since 5/21/2023
 */
public class Solution {

    public int shortestBridge(int[][] grid) {
        int length = grid.length;
        boolean[][] visited = new boolean[length][length];
        Queue<int[]> islandQueue = new LinkedList<>();
        int[][] directions = new int[][]{
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };

        loop:
        for (int row = 0; row < length; row++) {
            for (int column = 0; column < length; column++) {
                if (grid[row][column] == 1) {
                    dfs(row, column, directions, grid, visited, islandQueue);
                    break loop;
                }
            }
        }

        return bfs(directions, grid, visited, islandQueue);
    }

    private boolean isInvalid(int row, int column, int length) {
        return row < 0 || column < 0 || row >= length || column >= length;
    }

    private void dfs(int row, int column, int[][] directions, int[][] grid, boolean[][] visited, Queue<int[]> islandQueue) {
        if (isInvalid(row, column, grid.length)
                || grid[row][column] == 0
                || visited[row][column]) {

            return;
        }

        visited[row][column] = true;
        islandQueue.add(new int[]{row, column});

        for (int[] direction : directions) {
            dfs(direction[0] + row, direction[1] + column, directions, grid, visited, islandQueue);
        }
    }

    private int bfs(int[][] directions, int[][] grid, boolean[][] visited, Queue<int[]> islandQueue) {
        int result = 0;

        while (!islandQueue.isEmpty()) {
            int queueSize = islandQueue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] position = islandQueue.remove();
                for (int[] direction : directions) {
                    int newRow = direction[0] + position[0];
                    int newColumn = direction[1] + position[1];

                    if (isInvalid(newRow, newColumn, grid.length) || visited[newRow][newColumn]) {
                        continue;
                    }

                    if (grid[newRow][newColumn] == 1) {
                        return result;
                    }

                    islandQueue.add(new int[]{newRow, newColumn});
                    visited[newRow][newColumn] = true;
                }
            }

            result++;
        }

        return -1;
    }
}
