package net.jinnjar.problem1679;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> numCountMap = new HashMap<>();
        int count = 0;

        for (int num : nums) numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);

        for (int num : nums) {
            int num1 = k - num;

            if (numCountMap.containsKey(num) && numCountMap.containsKey(num1)) {
                int numCount = numCountMap.get(num);

                if (num == num1) {
                    if (numCount > 1) {
                        count++;
                        numCountMap.put(num, numCountMap.get(num) - 2);
                        if (numCountMap.get(num) <= 0) numCountMap.remove(num);
                    } else {
                        numCountMap.remove(num);
                    }

                    continue;
                }

                int num1Count = numCountMap.get(num1);
                int minCount = Math.min(numCount, num1Count);

                numCount = numCount - minCount;
                num1Count = num1Count - minCount;

                if (numCount > 0) numCountMap.put(num, numCount);
                else numCountMap.remove(num);
                if (num1Count > 0) numCountMap.put(num1, num1Count);
                else numCountMap.remove(num1);

                count += minCount;
            }
        }

        return count;
    }
}