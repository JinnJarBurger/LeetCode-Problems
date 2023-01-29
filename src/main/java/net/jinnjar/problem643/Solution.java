package net.jinnjar.problem643;

/**
 * adnan
 * 2/19/2024
 */
public class Solution {

    public double findMaxAverage(int[] nums, int k) {
        int start = 0, end = k - 1;
        double currentAvg, maxAvg, sum = 0;

        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }

        maxAvg = sum / k;

        while (end <= nums.length - 1) {
            currentAvg = sum / k;

            if (currentAvg > maxAvg) maxAvg = currentAvg;

            sum -= nums[start];
            start++;
            end++;
            if (end <= nums.length - 1) sum += nums[end];
        }

        return maxAvg;
    }
}
