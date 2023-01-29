package net.jinnjar.problem1491;

public class Solution {

    public double average(int[] salary) {
        // Solution 1
        // return Arrays.stream(salary)
        // .sorted()
        // .skip(1)
        // .limit(salary.length - 2)
        // .average()
        // .orElse(0);

        // Solution 2 (fastest)
        int max = salary[0];
        int min = salary[0];
        double count = 0;

        for (int s : salary) {
            if (s > max) {
                max = s;
            }

            if (s < min) {
                min = s;
            }
        }

        for (int s : salary) {
            if (s != max && s != min) {
                count += s;
            }
        }

        return count / (salary.length - 2);
    }
}
