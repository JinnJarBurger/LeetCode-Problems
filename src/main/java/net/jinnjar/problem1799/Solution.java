package net.jinnjar.problem1799;

import java.util.HashMap;
import java.util.Map;

/**
 * @author adnan
 * @since 5/14/2023
 */
public class Solution {

    // TODO: Very slow need to make it fast (revisit)
    Map<Integer, Integer> cache = new HashMap<>();

    public int maxScore(int[] nums) {
        return getAns(0, 1, nums);
    }

    private int getAns(int bitMask, int operationNo, int[] nums) {
        if (cache.containsKey(bitMask)) return cache.get(bitMask);
        int newMask, score;
        cache.put(bitMask, 0);

        for (int i = 0; i < nums.length; i++) {
            if (((1 << i) & bitMask) != 0) continue;

            for (int j = i + 1; j < nums.length; j++) {
                if (((1 << j) & bitMask) != 0) continue;

                newMask = bitMask | (1 << i) | (1 << j);
                score = operationNo * gcd(nums[i], nums[j]);
                cache.put(bitMask, Math.max(cache.get(bitMask), score + getAns(newMask, operationNo + 1, nums)));
            }
        }

        return cache.get(bitMask);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
