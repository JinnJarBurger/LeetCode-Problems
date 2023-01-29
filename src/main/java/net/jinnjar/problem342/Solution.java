package net.jinnjar.problem342;

/**
 * @author adnan
 * @since 10/27/2023
 */
public class Solution {

    public boolean isPowerOfFour(int n) {
        return n > 0 && (Math.log(n) / Math.log(4)) % 1 == 0;
    }
}
