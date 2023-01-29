package net.jinnjar.problem427;

import net.jinnjar.common.tree.quad.Node;

/**
 * @author adnan
 * @since 2/28/2023
 */
public class Solution {

    public Node construct(int[][] grid) {
        return quadTree(grid, grid.length, 0, 0);
    }

    private Node quadTree(int[][] grid, int n, int row, int column) {
        boolean isAllSameVal = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[row][column] != grid[row + i][column + j]) {
                    isAllSameVal = false;
                    break;
                }
            }
        }

        if (isAllSameVal) return new Node(grid[row][column] == 1, true);

        n /= 2;

        Node topLeft = quadTree(grid, n, row, column);
        Node topRight = quadTree(grid, n, row, column + n);
        Node bottomLeft = quadTree(grid, n, row + n, column);
        Node bottomRight = quadTree(grid, n, row + n, column + n);

        return new Node(grid[row][column] == 1, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
