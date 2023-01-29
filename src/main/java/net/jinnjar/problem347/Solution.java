package net.jinnjar.problem347;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * @author adnan
 * @since 5/22/2023
 */
public class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        // Solution 1 (Decent Speed, Bad Space Complexity)
        int[] ans = new int[k];
        Map<Integer, Integer> numFrequency = new HashMap<>();
        PriorityQueue<Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(Entry.comparingByValue(Comparator.reverseOrder()));

        for (int num : nums) {
            numFrequency.put(num, numFrequency.getOrDefault(num, 0) + 1);
        }

        priorityQueue.addAll(numFrequency.entrySet());

        for (int i = 0; i < k; i++) {
            ans[i] = priorityQueue.poll().getKey();
        }

        return ans;
    }
}
