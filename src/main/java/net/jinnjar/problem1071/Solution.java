package net.jinnjar.problem1071;

/**
 * @author adnan
 * @since 2/4/2023
 */
public class Solution {

    public String gcdOfStrings(String str1, String str2) {
        boolean isStr1GreaterThanStr2 = str1.length() > str2.length();
        int index = isStr1GreaterThanStr2 ? str2.length() : str1.length();
        String longString = isStr1GreaterThanStr2 ? str1 : str2;
        String shortString = isStr1GreaterThanStr2 ? str2 : str1;
        String subString = "";

        while (index > 0) {
            if (longString.length() % index == 0 && shortString.length() % index == 0) {
                subString = shortString.substring(0, index);

                if (longString.equals(subString.repeat((longString.length() / index)))
                        && shortString.equals(subString.repeat(shortString.length() / index))) {

                    break;
                }

            }

            index--;
        }

        return index > 0 ? subString : "";
    }
}
