package net.jinnjar.problem540;

/**
 * @author adnan
 * @since 2/21/2023
 */
public class Solution {

    public int singleNonDuplicate(int[] nums) {
        return findNonDuplicate(nums, 0, nums.length - 1);
    }

    private int findNonDuplicate(int[] arr, int start, int end) {
        if (start == end) {
            return arr[end];
        }

        int midIndex = (start + end) / 2;

        if (arr[midIndex] == arr[midIndex - 1]) {
            if (midIndex % 2 != 0) {
                return findNonDuplicate(arr, midIndex + 1, end);
            }

            return findNonDuplicate(arr, start, midIndex - 2);
        } else if (arr[midIndex] == arr[midIndex + 1]) {
            if (midIndex % 2 == 0) {
                return findNonDuplicate(arr, midIndex + 2, end);
            }

            return findNonDuplicate(arr, start, midIndex - 1);
        } else {
            return arr[midIndex];
        }
    }
}
