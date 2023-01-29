package net.jinnjar.problem837;

import java.util.HashMap;
import java.util.Map;

/**
 * @author adnan
 * @since 5/26/2023
 */
public class Solution {

    public double new21Game(int n, int k, int maxPts) {
        if (k == 0) return 1;

        double windowSum = 0;

        for (int i = k; i < k + maxPts; i++) windowSum += i <= n ? 1 : 0;

        Map<Integer, Double> cache = new HashMap<>();

        for (int i = k - 1; i >= 0; i--) {
            double removalValue = 0;
            cache.put(i, windowSum / maxPts);

            if (i + maxPts <= n) removalValue = cache.getOrDefault(i + maxPts, 1.0);

            windowSum += cache.get(i) - removalValue;
        }

        return cache.get(0);
    }
}
