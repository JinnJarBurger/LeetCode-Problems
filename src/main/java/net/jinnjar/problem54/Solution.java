package net.jinnjar.problem54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adnan
 * @since 5/10/2023
 */
public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        // Solution 1 (Fastest, Decent Space Complexity)
        if (matrix.length == 1 && matrix[0].length == 1) return List.of(matrix[0][0]);
        else if (matrix.length == 0) return new ArrayList<>();

        List<Integer> answer = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                answer.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                answer.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    answer.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    answer.add(matrix[i][left]);
                }
                left++;
            }
        }

        return answer;
    }
}
