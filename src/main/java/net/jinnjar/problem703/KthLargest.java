package net.jinnjar.problem703;

import java.util.PriorityQueue;

/**
 * @author adnan
 * @since 5/23/2023
 */
public class KthLargest {

    // Solution 1 (> Average speed, Bad Space Complexity)
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;

        for (int num : nums) {
            priorityQueue.add(num);
        }

        while (priorityQueue.size() > k) {
            priorityQueue.poll();
        }
    }

    public int add(int val) {
        priorityQueue.add(val);

        if (priorityQueue.size() > k) priorityQueue.poll();

        return priorityQueue.peek();
    }
}
