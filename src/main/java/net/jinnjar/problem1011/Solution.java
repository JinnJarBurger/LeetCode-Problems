package net.jinnjar.problem1011;

/**
 * @author adnan
 * @since 2/22/2023
 */
public class Solution {

    private int maxDays;
    private int[] weights;

    public int shipWithinDays(int[] weights, int days) {
        this.maxDays = days;
        this.weights = weights;
        int low = weights[0];
        int high = 0;

        for (int weight : weights) {
            high += weight;
            low = Math.max(low, weight);
        }

        return processShipment(low, high);
    }

    private int processShipment(int low, int high) {
        int mid = (low + high) / 2;

        if (low > high) return low;

        if (isPossible(mid)) return processShipment(low, mid - 1);
        else return processShipment(mid + 1, high);
    }

    private boolean isPossible(int capacity) {
        int days = 1;
        int weight = 0;

        for (int i : weights) {
            if (i > capacity) return false;

            if (weight + i > capacity) {
                days++;
                weight = 0;
            }

            weight += i;
        }

        return days <= maxDays;
    }
}
