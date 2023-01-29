package net.jinnjar.problem35;

/**
 * @author adnan
 * @since 2/20/2023
 */
public class Solution {

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        return searchTarget(nums, 0, nums.length - 1, target);
    }

    public int searchTarget(int[] arr, int start, int end, int target) {
        int midIndex = (start + end) / 2;

        if (target == arr[midIndex]) {
            return midIndex;
        }

        if (start == end) {
            if (target == arr[end]) {
                return end;
            } else if (target > arr[end]) {
                return end + 1;
            } else if (target < arr[end]) {
                return end;
            }
        }

        if (target > arr[midIndex]) {
            return searchTarget(arr, midIndex + 1, end, target);
        } else {
            return searchTarget(arr, start, midIndex, target);
        }
    }
}
