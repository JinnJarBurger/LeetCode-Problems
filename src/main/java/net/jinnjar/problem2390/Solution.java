package net.jinnjar.problem2390;

import java.util.Stack;

/**
 * @author adnan
 * @since 6/16/2023
 */
public class Solution {

    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '*') stack.pop();
            else stack.push(c);
        }

        StringBuilder ans = new StringBuilder();

        while (!stack.empty()) ans.append(stack.pop());

        return ans.reverse().toString();
    }
}
