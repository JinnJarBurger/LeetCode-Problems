package net.jinnjar.problem1768;

/**
 * @author adnan
 * @since 4/18/2023
 */
public class Solution {

    public String mergeAlternately(String word1, String word2) {
        char[] result = new char[word1.length() + word2.length()];
        int i = 0;
        int j = 0;
        int limit = Math.min(word1.length(), word2.length());

        while (i < limit) {
            result[j] = word1.charAt(i);
            result[++j] = word2.charAt(i);

            i++;
            j++;
        }

        if (word1.length() > word2.length()) {
            while (j < result.length) {
                result[j] = word1.charAt(i);

                i++;
                j++;
            }
        } else if (word2.length() > word1.length()) {
            while (j < result.length) {
                result[j] = word2.charAt(i);

                i++;
                j++;
            }
        }

        return new String(result);
    }
}
