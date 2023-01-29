package net.jinnjar.problem1675;

import java.util.TreeSet;

/**
 * @author adnan
 * @since 2/24/2023
 */
public class Solution {

    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i : nums) {
            if (i % 2 != 0) i *= 2;

            treeSet.add(i);
        }

        int max = treeSet.last();
        int min = treeSet.first();
        int diff = max - min;

        while (true) {
            if (max % 2 == 0) {
                treeSet.remove(max);

                max /= 2;

                treeSet.add(max);

                if (min > max) min = max;

                max = treeSet.last();

                if (diff > (max - min)) diff = max - min;
            } else {
                break;
            }
        }

        return diff;
    }
}
