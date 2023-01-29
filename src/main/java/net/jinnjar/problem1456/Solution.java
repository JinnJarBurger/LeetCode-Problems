package net.jinnjar.problem1456;

/**
 * @author adnan
 * @since 5/5/2023
 */
public class Solution {

    public int maxVowels(String s, int k) {
        // Solution 1 (pretty fast, decent space complexity)
        int currentCount = 0;
        int start = 0;
        int end = k;

        for (int i = start; i < end; i++) {
            switch (s.charAt(i)) {
                case 'a', 'e', 'i', 'o', 'u' -> currentCount++;
            }
        }

        int maxCount = currentCount;

        while (end < s.length()) {
            switch (s.charAt(start++)) {
                case 'a', 'e', 'i', 'o', 'u' -> currentCount--;
            }

            switch (s.charAt(end)) {
                case 'a', 'e', 'i', 'o', 'u' -> currentCount++;
            }

            if (currentCount > maxCount) maxCount = currentCount;

            end++;
        }

        return maxCount;
    }
}
