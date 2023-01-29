package net.jinnjar.problem136;

import java.util.HashMap;

/**
 * adnan
 * 2/7/2024
 */
public class Solution {

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : nums) {
            if (map.get(i) == 1) {
                return i;
            }
        }

        return 0;
    }
}
