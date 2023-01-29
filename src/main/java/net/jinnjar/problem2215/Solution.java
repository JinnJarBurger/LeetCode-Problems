package net.jinnjar.problem2215;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author adnan
 * @since 5/3/2023
 */
public class Solution {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nums1Map = new HashMap<>();
        Map<Integer, Integer> nums2Map = new HashMap<>();
        List<List<Integer>> answer = new ArrayList<>();

        answer.add(new ArrayList<>());
        answer.add(new ArrayList<>());

        for (int num : nums1) {
            nums1Map.put(num, num);
        }

        for (int num : nums2) {
            nums2Map.put(num, num);
        }

        for (int num : nums1) {
            if (nums2Map.containsKey(num)) {
                nums1Map.remove(num);
                nums2Map.remove(num);
            }
        }

        for (Integer value : nums1Map.values()) {
            answer.get(0).add(value);
        }

        for (Integer value : nums2Map.values()) {
            answer.get(1).add(value);
        }

        return answer;
    }
}
