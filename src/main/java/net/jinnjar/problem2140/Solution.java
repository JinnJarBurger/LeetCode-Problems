package net.jinnjar.problem2140;

/**
 * @author adnan
 * @since 5/12/2023
 */
public class Solution {

    public long mostPoints(int[][] questions) {
        // Solution 1 (Slow, Decent Space Complexity)
//        Map<Integer, Long> maxPoint = new HashMap<>();
//
//        for (int i = questions.length - 1; i >= 0; i--) {
//            maxPoint.put(i, Math.max(maxPoint.getOrDefault(i + 1, 0L),
//                    questions[i][0] + maxPoint.getOrDefault(i + 1 + questions[i][1], 0L)));
//        }
//
//        return maxPoint.get(0);

        // Solution 2 (Pretty Fast, Excellent Space Complexity)
        long[] maxPoints = new long[questions.length];

        for (int i = questions.length - 1; i >= 0; i--) {
            maxPoints[i] = Math.max(questions[i][0] + (i + 1 + questions[i][1] < questions.length
                    ? maxPoints[i + 1 + questions[i][1]] : 0), i + 1 < questions.length ? maxPoints[i + 1] : 0);
        }

        return maxPoints[0];
    }
}
