package net.jinnjar.problem1822;

public class Solution {

    public int arraySign(int[] nums) {
        // Solution 1
        /*
        return Arrays.stream(nums)
                .map(num -> Integer.compare(num, 0))
                .reduce((a, b) -> a * b)
                .orElse(0);
         */

        // Solution 2 (Fastest)
        int prod = 1;

        for (int num : nums) {
            if (num == 0) return 0;
            else if (num < 0) prod *= -1;
        }

        return prod;
    }
}
