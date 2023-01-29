package net.jinnjar.problem2542;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author adnan
 * @since 5/24/2023
 */
public class Solution {

    // Solution 1 (Slow, Decent Space Complexity)
    public long maxScore(int[] nums1, int[] nums2, int k) {
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;
        long res = 0;

        for (int i = 0; i < nums1.length; i++) {
            pairs.add(new Pair<>(nums1[i], nums2[i]));
        }

        Collections.sort(pairs);

        for (Pair<Integer, Integer> pair : pairs) {
            sum += pair.firstValue;
            minHeap.add(pair.firstValue);

            if (minHeap.size() > k) sum -= minHeap.poll();
            if (minHeap.size() == k) res = Math.max(res, sum * pair.secondValue);
        }

        return res;
    }
}

class Pair<T, F> implements Comparable<Pair<T, F>> {

    T firstValue;
    F secondValue;

    public Pair(T t, F f) {
        firstValue = t;
        secondValue = f;
    }

    @Override
    public int compareTo(Pair<T, F> o) {
        if (o.secondValue instanceof Integer && this.secondValue instanceof Integer)
            return Integer.compare((Integer) o.secondValue, (Integer) this.secondValue);

        return 0;
    }
}
