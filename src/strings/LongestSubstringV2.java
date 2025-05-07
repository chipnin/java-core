package strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Issue in https://leetcode.com/problems/longest-substring-without-repeating-characters/?envType=problem-list-v2&envId=string
 */
public class LongestSubstringV2 {
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
            int maxLength = 0;
            for (int i = 0; i < s.length(); i++) {
                for (int j = i; j < s.length(); j++) {
                    String substring = s.substring(i, j + 1);
                    int subStringLength = substring.length();
                    if (maxLength >= subStringLength) {
                        continue;
                    }
                    if (checkValidSubString(substring)) {
                        maxLength = subStringLength;
                    } else {
                        break;
                    }
                }
            }
            return maxLength;
        }

        private boolean checkValidSubString(String s) {
            int length = s.length();
            if (length == 1) {
                return true;
            }
            Set<Character> setChars = new HashSet<>();
            setChars.add(s.charAt(0));
            for (int i = 1; i < length; i++) {
                int preSetLength = setChars.size();
                setChars.add(s.charAt(i));
                if (preSetLength == setChars.size()) {
                    return false;
                }
            }

            return true;
        }
    }
}
