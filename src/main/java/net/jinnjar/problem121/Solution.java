package net.jinnjar.problem121;

/**
 * @author adnan
 * @since 2/25/2023
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int diff = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];
            if (prices[i] - min > diff) diff = prices[i] - min;
        }

        return diff;
    }
}
