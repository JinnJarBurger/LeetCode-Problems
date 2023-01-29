package net.jinnjar.problem1523;

/**
 * @author adnan
 * @since 2/13/2023
 */
public class Solution {

    public int countOdds(int low, int high) {
        return ((high - low) / 2) + (low % 2 == 0 && high % 2 == 0 ? 0 : 1);
    }
}
