package net.jinnjar.problem1980;

import java.util.HashMap;
import java.util.Map;

/**
 * @author adnan
 * @since 10/2/2022
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findDifferentBinaryString(new String[]{"111", "011", "000"}));
    }

    public String findDifferentBinaryString(String[] nums) {
        Map<String, String> binMap = new HashMap<>();

        int totNum = 0;
        for (int i = 0; i < nums.length; i++) {
            totNum += Math.pow(2, i);
        }

        StringBuilder result;
        String zeros;
        for (int i = 0; i <= totNum; i++) {
            result = new StringBuilder(Integer.toBinaryString(i));
            zeros = "0".repeat(nums.length - result.length());
            result.insert(0, zeros);
            binMap.put(result.toString(), result.toString());
        }

        for (String i : nums) {
            binMap.remove(i);
        }

        return binMap.entrySet().iterator().next().getValue();
    }
}
