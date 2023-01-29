package net.jinnjar.problem1547;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author adnan
 * @since 5/29/2023
 */
public class Solution {

    // Solution 1 (Slow, Bad Space Complexity)
    Map<Entry<Integer, Integer>, Integer> cache = new HashMap<>();

    public int minCost(int n, int[] cuts) {
        return solve(0, n, cuts);
    }

    private int solve(int left, int right, int[] cuts) {
        if (right - left == 1) return 0;
        if (cache.containsKey(Map.entry(left, right))) return cache.get(Map.entry(left, right));

        int ans = Integer.MAX_VALUE;

        for (int cut : cuts) {
            if (left < cut && cut < right) {
                ans = Math.min(ans, (right - left) + solve(left, cut, cuts) + solve(cut, right, cuts));
            }
        }

        ans = ans == Integer.MAX_VALUE ? 0 : ans;
        cache.put(Map.entry(left, right), ans);

        return ans;
    }
}
