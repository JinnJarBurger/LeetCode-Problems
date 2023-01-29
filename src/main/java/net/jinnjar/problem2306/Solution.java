package net.jinnjar.problem2306;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author adnan
 * @since 2/10/2023
 */
public class Solution {

    // TODO: decrease runtime
    public long distinctNames(String[] ideas) {
        Map<Character, Set<String>> firstLetterMap = new HashMap<>();
        long count = 0;

        for (String idea : ideas) {
            firstLetterMap.computeIfAbsent(idea.charAt(0), k -> new HashSet<>()).add(idea.substring(1));
        }

        for (Map.Entry<Character, Set<String>> entry1 : firstLetterMap.entrySet()) {
            for (Map.Entry<Character, Set<String>> entry2 : firstLetterMap.entrySet()) {
                if (entry1.getKey() == entry2.getKey()) continue;

                Set<String> intersection = new HashSet<>(entry1.getValue());
                intersection.retainAll(entry2.getValue());

                count += (long) (entry1.getValue().size() - intersection.size()) * (entry2.getValue().size() - intersection.size());
            }
        }

        return count;
    }
}
