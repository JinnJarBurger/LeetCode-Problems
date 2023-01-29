package net.jinnjar.problem875;

/**
 * adnan
 * 3/3/2024
 */
public class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];

        for (int pile : piles) if (pile > max) max = pile;

        return minKValue(piles, 1, max, h, max);
    }

    private int minKValue(int[] piles, int start, int end, int h, int kValue) {
        if (start > end) return kValue;

        int mid = (start + end) / 2;
        long totalHoursTaken = 0;

        for (int pile : piles) totalHoursTaken += Math.ceilDiv(pile, mid);

        if (totalHoursTaken <= h) {
            kValue = mid;
            return minKValue(piles, start, --mid, h, kValue);
        }

        return minKValue(piles, ++mid, end, h, kValue);
    }
}
