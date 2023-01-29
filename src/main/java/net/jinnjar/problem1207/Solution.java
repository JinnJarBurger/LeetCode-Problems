package net.jinnjar.problem1207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * adnan
 * 2/3/2024
 */
public class Solution {

    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> oc = new HashMap<>();
        HashMap<Integer, Integer> cc = new HashMap<>();
        Set<Integer> s = new HashSet<>();

        for (int i : arr) {
            oc.put(i, oc.getOrDefault(i, 0) + 1);
            s.add(i);
        }

        for (Integer i : s) {
            if (cc.containsKey(oc.get(i))) {
                return false;
            }

            cc.put(oc.get(i), i);
        }

        return true;
    }
}
