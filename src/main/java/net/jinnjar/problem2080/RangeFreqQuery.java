package net.jinnjar.problem2080;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author adnan
 * @since 8/28/2023
 */
public class RangeFreqQuery {

    HashMap<Integer, List<Integer>> freqMap = new HashMap<>();

    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            freqMap.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
    }

    public int query(int left, int right, int value) {
        if (!freqMap.containsKey(value)) return 0;

        List<Integer> indices = freqMap.get(value);
        int leftInd = Collections.binarySearch(indices, left);
        int rightInd = Collections.binarySearch(indices, right);

        if (leftInd < 0) leftInd = (leftInd + 1) * -1;
        if (rightInd < 0) rightInd = (rightInd + 2) * -1;

        return rightInd - leftInd + 1;
    }
}
