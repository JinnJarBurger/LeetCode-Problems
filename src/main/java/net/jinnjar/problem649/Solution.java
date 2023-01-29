package net.jinnjar.problem649;

/**
 * @author adnan
 * @since 5/4/2023
 */
public class Solution {

    public String predictPartyVictory(String senate) {
        // TODO: Implement time efficient solution

        // Solution 1 (Memory efficient && Not time efficient)
        if (senate.length() == 1) {
            return senate.startsWith("R") ? "Radiant" : "Dire";
        }

        boolean[] isBanned = new boolean[senate.length()];
        int radiantCount = 0;
        int direCount = 0;

        for (char c : senate.toCharArray()) {
            if (c == 'R') radiantCount++;
            else direCount++;
        }

        int i = 0;
        int currentInd;

        loop:
        while (radiantCount > 0 && direCount > 0) {
            currentInd = i % senate.length();

            if (senate.charAt(currentInd) == 'R' && !isBanned[currentInd]) {
                for (int j = currentInd; j < senate.length(); j++) {
                    if (senate.charAt(j) == 'D' && !isBanned[j]) {
                        isBanned[j] = true;
                        direCount--;
                        i++;

                        continue loop;
                    }
                }

                for (int j = 0; j <= currentInd; j++) {
                    if (senate.charAt(j) == 'D' && !isBanned[j]) {
                        isBanned[j] = true;
                        direCount--;
                        i++;

                        continue loop;
                    }
                }
            } else if (senate.charAt(currentInd) == 'D' && !isBanned[currentInd]) {
                for (int j = currentInd; j < senate.length(); j++) {
                    if (senate.charAt(j) == 'R' && !isBanned[j]) {
                        isBanned[j] = true;
                        radiantCount--;
                        i++;

                        continue loop;
                    }
                }

                for (int j = 0; j <= currentInd; j++) {
                    if (senate.charAt(j) == 'R' && !isBanned[j]) {
                        isBanned[j] = true;
                        radiantCount--;
                        i++;

                        continue loop;
                    }
                }
            }

            i++;
        }

        if (radiantCount > direCount) {
            return "Radiant";
        }

        return "Dire";
    }
}
