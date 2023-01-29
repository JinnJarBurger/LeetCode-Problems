package net.jinnjar.problem1140;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * @author adnan
 * @since 5/27/2023
 */
public class Solution {

    Map<Entry<Boolean, Entry<Integer, Integer>>, Integer> cache = new HashMap<>();

    public int stoneGameII(int[] piles) {
        return calculate(piles, true, 0, 1);
    }

    private int calculate(int[] piles, boolean isAlice, int index, int M) {
        if (index == piles.length) return 0;

        Entry<Boolean, Entry<Integer, Integer>> aLiceInfo = Map.entry(isAlice, Map.entry(index, M));

        if (cache.containsKey(aLiceInfo)) return cache.get(aLiceInfo);

        int result = isAlice ? 0 : Integer.MAX_VALUE;
        int total = 0;

        for (int X = 1; X <= 2 * M; X++) {
            if (index + X > piles.length) break;

            total += piles[index + X - 1];

            result = isAlice ? max(result, total + calculate(piles, false, index + X, max(M, X)))
                    : min(result, calculate(piles, true, index + X, max(M, X)));
        }

        cache.put(aLiceInfo, result);

        return result;
    }
}
