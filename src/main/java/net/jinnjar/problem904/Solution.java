package net.jinnjar.problem904;

import java.util.HashSet;
import java.util.Set;

/**
 * @author adnan
 * @since 2/7/2023
 */
public class Solution {

    public int totalFruit(int[] fruits) {
        if (fruits.length == 1 || fruits.length == 2) {
            return fruits.length;
        }

        Set<Integer> fruitBasket = new HashSet<>();
        fruitBasket.add(fruits[0]);
        fruitBasket.add(fruits[1]);

        int count = 0, max = 0, startIndex = 0, endIndex = 0;

        while (startIndex < fruits.length && endIndex < fruits.length) {
            if (fruitBasket.contains(fruits[endIndex])) {
                endIndex++;
                count++;
            } else if (!fruitBasket.contains(fruits[endIndex]) && fruitBasket.size() == 1) {
                fruitBasket.add(fruits[endIndex]);
            } else {
                fruitBasket.remove(fruits[startIndex]);

                if (fruitBasket.size() < 2) {
                    fruitBasket.add(fruits[endIndex]);
                }

                if (count > max) {
                    max = count;
                }

                endIndex = ++startIndex;
                count = 0;
            }
        }

        if (count > max) {
            max = count;
        }

        return max;
    }
}
