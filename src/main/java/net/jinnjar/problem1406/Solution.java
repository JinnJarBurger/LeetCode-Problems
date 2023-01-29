package net.jinnjar.problem1406;

/**
 * @author adnan
 * @since 5/27/2023
 */
public class Solution {

    long[] cache;

    // Solution 1 (Below Average Speed, Worst Space Complexity)
    public String stoneGameIII(int[] stoneValue) {
        cache = new long[stoneValue.length];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = Long.MIN_VALUE;
        }

        long ans = solve(0, stoneValue);

        if (ans > 0) return "Alice";
        else if (ans < 0) return "Bob";
        else return "Tie";
    }

    public long solve(int i, int[] stoneValue) {
        if (i == stoneValue.length) return 0;
        if (cache[i] != Long.MIN_VALUE) return cache[i];

        long ans = Long.MIN_VALUE;
        long sum = 0;

        for (int j = i; j < Math.min(i + 3, stoneValue.length); j++) {
            sum += stoneValue[j];
            ans = Math.max(ans, sum - solve(j + 1, stoneValue));
        }

        cache[i] = ans;

        return ans;
    }
}
