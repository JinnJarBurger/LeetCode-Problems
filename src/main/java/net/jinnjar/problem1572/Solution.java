package net.jinnjar.problem1572;

/**
 * @author adnan
 * @since 5/8/2023
 */
public class Solution {

    public int diagonalSum(int[][] mat) {
        // Solution 1 (Fastest, Decent Space Complexity)
        int sum = 0;
        int row = 0;
        int column1 = 0;
        int column2 = mat.length - 1;

        while (row < mat.length) {
            if (column1 == column2) {
                sum += mat[row][column1];
            } else {
                sum = sum + mat[row][column1] + mat[row][column2];
            }

            column1++;
            column2--;
            row++;
        }

        return sum;
    }
}
