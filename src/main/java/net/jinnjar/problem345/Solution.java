package net.jinnjar.problem345;

import java.util.Map;

/**
 * adnan
 * 1/29/2024
 */
public class Solution {

    public String reverseVowels(String s) {
        var vowels = Map.of(
                'A', 'A',
                'E', 'E',
                'I', 'I',
                'O', 'O',
                'U', 'U',
                'a', 'a',
                'e', 'e',
                'i', 'i',
                'o', 'o',
                'u', 'u'
        );
        var chars = s.toCharArray();
        int start = 0, end = chars.length - 1;
        char tmp;


        while (start < end) {
            if (vowels.containsKey(chars[start])) {
                if (vowels.containsKey(chars[end])) {
                    tmp = chars[start];
                    chars[start] = chars[end];
                    chars[end] = tmp;

                    start++;
                }

                end--;
                continue;
            }

            if (vowels.containsKey(chars[end])) {
                if (vowels.containsKey(chars[start])) {
                    tmp = chars[start];
                    chars[start] = chars[end];
                    chars[end] = tmp;

                    end--;
                }

                start++;
                continue;
            }

            if (vowels.containsKey(chars[start]) && vowels.containsKey(chars[end])) {
                tmp = chars[start];
                chars[start] = chars[end];
                chars[end] = tmp;
            }

            start++;
            end--;
        }

        return String.valueOf(chars);
    }
}
