package net.jinnjar.problem1498;

import java.util.Arrays;

/**
 * @author adnan
 * @since 5/6/2023
 */
public class Solution {

    public int numSubseq(int[] nums, int target) {
        // Solution 1 (fastest, less than average space complexity)
        int subSeqCount = 0;
        int start = 0;
        int end = nums.length - 1;
        int mod = (int) (Math.pow(10, 9) + 7);
        int[] twosPower = new int[nums.length];

        twosPower[0] = 1;

        for (int i = 1; i < nums.length; ++i) {
            twosPower[i] = (twosPower[i - 1] * 2) % mod;
        }

        Arrays.sort(nums);

        while (start <= end) {
            if (nums[start] + nums[end] <= target) {
                subSeqCount += twosPower[end - start];
                subSeqCount %= mod;

                start++;
            } else {
                end--;
            }
        }

        return subSeqCount;
    }
}
