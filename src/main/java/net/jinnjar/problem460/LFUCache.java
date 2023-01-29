package net.jinnjar.problem460;

import net.jinnjar.common.DoubleLinkedList;
import net.jinnjar.common.tree.binary.Node;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author adnan
 * @since 1/29/2023
 */
public class LFUCache {

    private final HashMap<Integer, Node> cacheValueMap;
    private final HashMap<Integer, Integer> cacheFrequencyMap;
    private final TreeMap<Integer, DoubleLinkedList> frequencyListMap;

    private final int maxCapacity;

    public LFUCache(int capacity) {
        cacheValueMap = new HashMap<>();
        cacheFrequencyMap = new HashMap<>();
        frequencyListMap = new TreeMap<>();
        maxCapacity = capacity;
    }

    public int get(int key) {
        if (!cacheValueMap.containsKey(key) || maxCapacity == 0) {
            return -1;
        }

        // first remove node which will be updated
        Node nodeToDelete = cacheValueMap.get(key);
        int value = nodeToDelete.getValue();
        int frequency = cacheFrequencyMap.get(key);
        frequencyListMap.get(frequency).remove(nodeToDelete);
        cacheValueMap.remove(key);
        cacheFrequencyMap.remove(key);

        checkFrequencyListMapStatus(frequency);

        // now insert the newly updated node and increase frequency
        Node nodeToUpdate = new Node(key, value);
        cacheValueMap.put(key, nodeToUpdate);
        cacheFrequencyMap.put(key, ++frequency);
        frequencyListMap.computeIfAbsent(frequency, integer -> new DoubleLinkedList()).add(nodeToUpdate);

        return cacheValueMap.get(key).getValue();
    }

    public void put(int key, int value) {
        Node nodeToInsert = new Node(key, value);

        if (!cacheValueMap.containsKey(key) && maxCapacity > 0) {
            // check if the cache space is max
            if (cacheValueMap.size() == maxCapacity) {
                // if so then remove the lowest frequency node
                int frequency = frequencyListMap.firstKey();
                Node head = frequencyListMap.get(frequency).head();
                int keyToRemove = head.getKey();
                cacheValueMap.remove(keyToRemove);
                cacheFrequencyMap.remove(keyToRemove);
                frequencyListMap.get(frequency).remove(head);

                checkFrequencyListMapStatus(frequency);
            }

            // Now insert the new node
            cacheValueMap.put(key, nodeToInsert);
            cacheFrequencyMap.put(key, 1);
            frequencyListMap.computeIfAbsent(1, integer -> new DoubleLinkedList()).add(nodeToInsert);
        } else if (maxCapacity > 0) {
            // If valueMap contains then just insert and update
            Node nodeToDelete = cacheValueMap.get(key);
            int frequency = cacheFrequencyMap.get(key);
            cacheValueMap.remove(key);
            cacheFrequencyMap.remove(key);
            frequencyListMap.get(frequency).remove(nodeToDelete);

            checkFrequencyListMapStatus(frequency);

            cacheValueMap.put(key, nodeToInsert);
            cacheFrequencyMap.put(key, ++frequency);
            frequencyListMap.computeIfAbsent(frequency, integer -> new DoubleLinkedList()).add(nodeToInsert);
        }
    }

    private void checkFrequencyListMapStatus(int frequency) {
        // check if the corresponding DoubleLinkedList has gotten empty
        if (frequencyListMap.get(frequency).isEmpty()) {
            frequencyListMap.remove(frequency);
        }
    }
}
