package net.jinnjar.problem502;

import net.jinnjar.common.Pair;

import java.util.*;

/**
 * @author adnan
 * @since 2/24/2023
 */
public class Solution {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Pair[] capitalProfit = new Pair[capital.length];
        Queue<Integer> queue = new PriorityQueue<>(capital.length, Collections.reverseOrder());

        for (int i = 0; i < capital.length; i++) capitalProfit[i] = (new Pair(capital[i], profits[i]));

        Arrays.sort(capitalProfit);

        int indInc = 0;

        for (int i = 0; i < k; i++) {
            while (indInc < capital.length && capitalProfit[indInc].firstVal <= w) queue.add(capitalProfit[indInc++].secondVal);

            if (queue.isEmpty()) break;

            w += queue.remove();
        }

        return w;
    }
}
