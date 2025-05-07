package strings;

import java.util.ArrayList;

/**
 * Issue in https://leetcode.com/problems/longest-palindromic-substring/description/?envType=problem-list-v2&envId=string
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String[] testCases = {"abcabcbb", "babad", "cbbd", "au", "4ab1ba2"};
        for (String test : testCases) {
            Solution solution = new Solution();
            String longest = solution.longestPalindrome(test);
            System.out.println("Input: " + test + " - Output: " + longest);
        }
    }

    static class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.isEmpty()) {
                return "";
            }
            if (s.length() == 1) {
                return s;
            }

            int startSubString = 0;
            int endSubString = 0;
            int maxLength = 0;
            for (int i = 0; i < s.length() - 1; i++) {
                for (int j = i + 1; j < s.length(); j++) {
                    int subStringLength = j - i + 1;
                    if (subStringLength <= maxLength) {
                        continue;
                    }
                    if (checkIsPalindrome(s, i, j)) {
                        maxLength = subStringLength;
                        startSubString = i;
                        endSubString = j;
                    }
                }
            }
            return s.substring(startSubString, endSubString + 1);
        }

        private boolean checkIsPalindrome(String s, int indexStart, int indexEnd) {
            if (indexStart == indexEnd) {
                return true;
            }
            int half = Math.ceilDiv(indexEnd - indexStart + 1, 2);
            for (int i = indexStart; i < indexStart + half; i++) {
                if (s.charAt(i) != s.charAt(indexEnd + indexStart - i)) {
                    return false;
                }
            }

            return true;
        }
    }
}
