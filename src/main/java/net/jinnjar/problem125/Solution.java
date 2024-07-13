package net.jinnjar.problem125;

import java.util.ArrayList;
import java.util.List;

/**
 * adnan
 * 7/13/2024
 */
public class Solution {

    public boolean isPalindrome(String s) {
        List<Character> charList = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if ((c >= 'a' && c <= 'z')
                    || (c >= 'A' && c <= 'Z')
                    || (c >= '0' && c <= '9')) {

                charList.add(Character.toLowerCase(c));
            }
        }

        for (int i = 0; i < charList.size() - 1 - i; i++) {
            if (charList.get(i) != charList.get(charList.size() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
