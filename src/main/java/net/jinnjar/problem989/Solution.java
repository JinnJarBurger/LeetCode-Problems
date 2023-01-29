package net.jinnjar.problem989;

import java.util.LinkedList;
import java.util.List;

/**
 * @author adnan
 * @since 2/15/2023
 */
public class Solution {

    public List<Integer> addToArrayForm(int[] num, int k) {
        int carry = k;
        List<Integer> answer = new LinkedList<>();
        int i = num.length - 1;

        while (i >= 0 || carry > 0) {
            int sum = (i >= 0 ? num[i] : 0) + carry;
            carry = sum / 10;
            answer.add(0, sum % 10);
            i--;
        }

        return answer;
    }
}
