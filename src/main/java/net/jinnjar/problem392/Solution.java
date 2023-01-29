package net.jinnjar.problem392;

/**
 * adnan
 * 3/1/2024
 */
public class Solution {

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;

        for (int i = 0, j = 0; i < t.length(); i++) {
            if (s.charAt(j) == t.charAt(i)) j++;

            if (j == s.length()) return true;
        }

        return false;
    }
}
