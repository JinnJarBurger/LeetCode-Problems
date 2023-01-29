package net.jinnjar.problem1035;

/**
 * @author adnan
 * @since 5/11/2023
 */
public class Solution {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // Solution 1 (Fast, Bad Space Complexity)
//        int[][] lines = new int[nums1.length + 1][nums2.length + 1];
//
//        for (int i = 1; i < lines.length; i++) {
//            for (int j = 1; j < lines[0].length; j++) {
//                if (nums1[i - 1] == nums2[j - 1]) lines[i][j] = lines[i - 1][j - 1] + 1;
//                else lines[i][j] = Math.max(lines[i - 1][j], lines[i][j - 1]);
//            }
//        }
//
//        return lines[nums1.length][nums2.length];

        // Solution 2 (Fastest, Better Space Management)
        int[] prevLine = new int[nums2.length + 1];
        int[] line;

        for (int i = 1; i <= nums1.length; i++) {
            line = new int[nums2.length + 1];

            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) line[j] = prevLine[j - 1] + 1;
                else line[j] = Math.max(line[j - 1], prevLine[j]);
            }

            prevLine = line;
        }

        return prevLine[nums2.length];
    }
}
