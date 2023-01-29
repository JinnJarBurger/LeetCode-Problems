package net.jinnjar.problem1657;

import java.util.*;

/**
 * adnan
 * 3/11/2024
 */
public class Solution {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        Map<Character, Integer> uniqueCharsCount1 = new HashMap<>();
        Map<Character, Integer> uniqueCharsCount2 = new HashMap<>();
        Queue<Integer> frequency1 = new PriorityQueue<>();
        Queue<Integer> frequency2 = new PriorityQueue<>();

        for (char c : word1.toCharArray()) uniqueCharsCount1.put(c, uniqueCharsCount1.getOrDefault(c, 0) + 1);

        for (char c : word2.toCharArray()) {
            if (!uniqueCharsCount1.containsKey(c)) return false;

            uniqueCharsCount2.put(c, uniqueCharsCount2.getOrDefault(c, 0) + 1);
        }

        frequency1.addAll(uniqueCharsCount1.values());
        frequency2.addAll(uniqueCharsCount2.values());

        while (true) {
            if (!Objects.equals(frequency1.poll(), frequency2.poll())) return false;

            if (frequency1.isEmpty() || frequency2.isEmpty()) return true;
        }
    }
}
