package net.jinnjar.problem399;

import java.util.*;
import java.util.Map.Entry;

/**
 * @author adnan
 * @since 5/20/2023
 */
public class Solution {


    // Solution 1 (Very Fast, Very Good Space Complexity)
    Map<String, Map<String, Double>> equationMap = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);

            equationMap.putIfAbsent(dividend, new HashMap<>());
            equationMap.putIfAbsent(divisor, new HashMap<>());
            equationMap.get(dividend).put(divisor, values[i]);
            equationMap.get(divisor).put(dividend, 1 / values[i]);
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < ans.length; i++) {
            String source = queries.get(i).get(0);
            String destination = queries.get(i).get(1);

            if (!equationMap.containsKey(source) || !equationMap.containsKey(destination)) {
                ans[i] = -1;
            } else {
                ans[i] = calculate(source, destination);
            }
        }

        return ans;
    }

    private double calculate(String source, String destination) {
        Queue<Entry<String, Double>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Entry<String, Double> current;

        queue.add(new AbstractMap.SimpleEntry<>(source, 1.));
        visited.add(source);

        String currentNode;
        double currentValue;

        while (!queue.isEmpty()) {
            current = queue.remove();
            currentNode = current.getKey();
            currentValue = current.getValue();

            if (Objects.equals(currentNode, destination)) return currentValue;
            visited.add(currentNode);

            for (Entry<String, Double> keyVal : equationMap.get(currentNode).entrySet()) {
                if (!visited.contains(keyVal.getKey())) {
                    queue.add(new AbstractMap.SimpleEntry<>(keyVal.getKey(), currentValue * keyVal.getValue()));
                }
            }
        }

        return -1;
    }
}
