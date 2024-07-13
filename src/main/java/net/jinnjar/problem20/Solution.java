package net.jinnjar.problem20;

import java.util.Stack;

/**
 * adnan
 * 7/13/2024
 */
public class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                case '{':
                case '[':
                    stack.push(s.charAt(i));
                    break;

                case ')':
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != '(') return false;

                    break;

                case '}':
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != '{') return false;

                    break;

                case ']':
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != '[') return false;

                    break;
            }
        }

        return stack.isEmpty();
    }
}
