package net.jinnjar.problem6;

import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author adnan
 * @since 2/4/2023
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("AB", 1));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        HashMap<Integer, StringBuilder> zigzagMap = new HashMap<>();
        int count = 0;
        int i = 0;

        while (i < s.length()){
            count %= numRows;

            if (count == 0) {
                for (int j = 0; j < numRows; j++) {
                    if (i >= s.length()) {
                        break;
                    }

                    if (j == 0 && i != 0) {
                        continue;
                    }

                    if (zigzagMap.containsKey(j)) {
                        zigzagMap.get(j).append(s.charAt(i));
                    } else {
                        zigzagMap.put(j, new StringBuilder().append(s.charAt(i)));
                    }

                    i++;
                }

                count++;
                continue;
            }

            if (zigzagMap.containsKey(numRows - count - 1)) {
                zigzagMap.get(numRows - count - 1).append(s.charAt(i));
            } else {
                zigzagMap.put(numRows - count - 1, new StringBuilder().append(s.charAt(i)));
            }

            count++;
            i++;
        }

        return IntStream.range(0, numRows)
                .mapToObj(num -> zigzagMap.getOrDefault(num, new StringBuilder()).toString())
                .collect(Collectors.joining());
    }
}
