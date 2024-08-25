package net.jinnjar.problem70;

/**
 * adnan
 * 8/25/2024
 */
public class Solution {

    public int climbStairs(int n) {
        int currVal = 1, prevVal = 1, tmp;

        for (int i = 0; i < n; i++) {
            tmp = prevVal;
            prevVal = prevVal + currVal;
            currVal = tmp;
        }

        return currVal;
    }
}
