package net.jinnjar.problem435;

import java.util.Arrays;
import java.util.Comparator;

/**
 * adnan
 * 4/19/2024
 */
public class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int count = 0;
        int curLast = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < curLast) {
                count++;
                curLast = Math.min(curLast, intervals[i][1]);

                continue;
            }

            curLast = Math.max(curLast, intervals[i][1]);
        }

        return count;
    }
}
