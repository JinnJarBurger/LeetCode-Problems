package net.jinnjar.problem3;

import java.util.HashSet;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;

        if (s.length() == 1) return 1;

        HashSet<Character> hashSet = new HashSet<>();
        char[] chars = s.toCharArray();
        int slider1 = 0, slider2 = 1, maxLength = 0;

        hashSet.add(chars[0]);

        while (slider2 < chars.length) {
            if (hashSet.contains(chars[slider2])) {
                while (chars[slider1] != chars[slider2]) {
                    hashSet.remove(chars[slider1]);
                    slider1++;
                }

                hashSet.remove(chars[slider1]);
                slider1++;
            }

            if (slider2 - slider1 + 1 > maxLength) maxLength = slider2 - slider1 + 1;

            hashSet.add(chars[slider2]);
            slider2++;
        }

        return maxLength;
    }
}
