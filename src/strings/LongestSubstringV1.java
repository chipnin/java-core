package strings;

import java.util.ArrayList;

/**
 * Issue in https://leetcode.com/problems/longest-substring-without-repeating-characters/?envType=problem-list-v2&envId=string
 */
public class LongestSubstringV1 {
    public static void main(String[] args) {
        String[] testCases = {"abcabcbb", "bbbbb", "pwwkew", "au", " ", "   "};
        for (String test : testCases) {
            Solution solution = new Solution();
            int longest = solution.lengthOfLongestSubstring(test);
            System.out.println("Input: " + test + " - Output: " + longest);
        }
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }
            if (s.length() == 1) {
                return 1;
            }
            ArrayList<String> listSubStrings = getListSubStringWithUniqueChar(s);
            int maxLength = 0;
            for (int i = 0; i < listSubStrings.size(); i++) {
                int subStringLength = listSubStrings.get(i).length();
                if (subStringLength > maxLength) {
                    maxLength = subStringLength;
                }
            }
            return maxLength;
        }

        private ArrayList<String> getListSubStringWithUniqueChar(String s) {
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                for (int j = i; j < s.length(); j++) {
                    String substring = s.substring(i, j + 1);
                    if (checkValidSubString(substring)) {
                        list.add(substring);
                    } else {
                        break;
                    }
                }
            }

            return list;
        }

        private boolean checkValidSubString(String s) {
            if (s.isEmpty()) {
                return false;
            }
            int length = s.length();
            if (length == 1) {
                return true;
            }
            for (int i = 0; i < length - 1; i++) {
                for (int j = i + 1; j < length; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        return false;
                    }
                }
            }

            return true;
        }
    }
}
