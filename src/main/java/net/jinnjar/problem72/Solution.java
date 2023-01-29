package net.jinnjar.problem72;

/**
 * @author adnan
 * @since 2/26/2023
 */
public class Solution {

    public int minDistance(String word1, String word2) {
        int[][] wordMatrix = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i < wordMatrix[0].length; i++) {
            wordMatrix[0][i] = i;
        }

        for (int i = 0; i < wordMatrix.length; i++) {
            wordMatrix[i][0] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) wordMatrix[i][j] = wordMatrix[i - 1][j - 1];
                else wordMatrix[i][j] = Math.min(wordMatrix[i][j - 1], Math.min(wordMatrix[i - 1][j - 1], wordMatrix[i - 1][j])) + 1;
            }
        }

        return wordMatrix[word1.length()][word2.length()];
    }
}
