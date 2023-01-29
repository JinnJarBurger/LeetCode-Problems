package net.jinnjar.problem215;

/**
 * adnan
 * 2/4/2024
 */
public class Solution {

    // TODO
    public int findKthLargest(int[] nums, int k) {
        boolean[] visited = new boolean[nums.length];
        int max = 0, ind = 0;

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (!visited[j]) {
                    max = nums[j];
                    ind = j;

                    break;
                }
            }

            for (int j = 0; j < nums.length; j++) {
                if (!visited[j] && max < nums[j]) {
                    max = nums[j];
                    ind = j;
                }
            }

            visited[ind] = true;
        }

        return max;

//        Arrays.sort(nums);
//
//        return nums[nums.length - k];
    }
}
