package net.jinnjar.problem67;

/**
 * @author adnan
 * @since 2/14/2023
 */
public class Solution {

    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder result = new StringBuilder();

        int maxLength = Math.max(a.length(), b.length());

        if (maxLength > a.length()) {
            a = "0".repeat(maxLength - a.length()) + a;
        } else {
            b = "0".repeat(maxLength - b.length()) + b;
        }

        for (int i = maxLength - 1; i >= 0; i--) {
            if (a.charAt(i) == '0' && b.charAt(i) == '0') {
                if (carry == 1) {
                    result.insert(0, "1");
                    carry = 0;
                } else {
                    result.insert(0, "0");
                }
            } else if (a.charAt(i) == '1' && b.charAt(i) == '0'
                    || a.charAt(i) == '0' && b.charAt(i) == '1') {

                if (carry == 1) {
                    result.insert(0, "0");
                } else {
                    result.insert(0, "1");
                }
            } else {
                if (carry == 1) {
                    result.insert(0, "1");
                } else {
                    result.insert(0, "0");
                    carry = 1;
                }
            }
        }

        if (carry == 1) result.insert(0, "1");

        return result.toString();
    }
}
