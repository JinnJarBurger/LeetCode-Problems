package net.jinnjar.problem59;

/**
 * @author adnan
 * @since 5/10/2023
 */
public class Solution {

    public int[][] generateMatrix(int n) {
        // Solution 1 (Fastest, Decent Space Complexity)
        if (n == 1) return new int[][]{new int[]{1}};

        int[][] ans = new int[n][n];
        int count = 0;
        int left = 0, top = 0;
        int right = n - 1, bottom = n - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                ans[top][i] = ++count;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                ans[i][right] = ++count;
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans[bottom][i] = ++count;
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans[i][left] = ++count;
                }
                left++;
            }
        }

        return ans;
    }
}
