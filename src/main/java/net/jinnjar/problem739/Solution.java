package net.jinnjar.problem739;

import java.util.Map;
import java.util.Stack;

/**
 * adnan
 * 4/12/2024
 */
public class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Map.Entry<Integer, Integer>> stack = new Stack<>();
        stack.push(Map.entry(0, temperatures[0]));

        for (int i = 1; i < temperatures.length; i++) {
            int currentTemp = temperatures[i];

            while (!stack.isEmpty() && currentTemp > stack.peek().getValue()) {
                Map.Entry<Integer, Integer> entry = stack.pop();
                res[entry.getKey()] = i - entry.getKey();
            }

            stack.push(Map.entry(i, currentTemp));
        }

        return res;
    }
}
