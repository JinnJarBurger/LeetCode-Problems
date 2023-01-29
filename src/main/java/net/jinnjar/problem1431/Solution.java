package net.jinnjar.problem1431;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adnan
 * @since 4/18/2023
 */
public class Solution {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        List<Boolean> result = new ArrayList<>(candies.length);

        for (int i = 1; i < candies.length; i++) {
           if (candies[i] > max) {
               max = candies[i];
           }
        }

        for (int i : candies) {
            result.add(i + extraCandies >= max);
        }

        return result;
    }
}
