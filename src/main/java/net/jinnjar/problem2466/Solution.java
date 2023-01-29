package net.jinnjar.problem2466;

/**
 * @author adnan
 * @since 5/13/2023
 */
public class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        // Solution 1 (Fast, Good Space Complexity)
        int mod = 1_000_000_007;
        int[] maxLength = new int[high + 1];
        maxLength[0] = 1;

        for (int i = 1; i <= high; i++) {
            maxLength[i] = ((i - zero >= 0 ? maxLength[i - zero] : 0) + (i - one >= 0 ? maxLength[i - one] : 0)) % mod;
        }

        int sum = 0;

        for (int i = low; i <= high; i++) {
            sum = (sum + maxLength[i]) % mod;
        }

        return sum % mod;
    }
}
