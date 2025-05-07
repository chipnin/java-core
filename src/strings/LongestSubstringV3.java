package strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Issue in https://leetcode.com/problems/longest-substring-without-repeating-characters/?envType=problem-list-v2&envId=string
 */
public class LongestSubstringV3 {
    public static void main(String[] args) {
        String[] testCases = {"abcabcbb", "bbbbb", "pwwkew", "au", " ", "   ", "abcadaedf"};
        for (String test : testCases) {
            Solution solution = new Solution();
            int longest = solution.lengthOfLongestSubstring(test);
            System.out.println("Input: " + test + " - Output: " + longest);
        }
    }

    /**
     * Using sliding window + HashSet
     */
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }

            int maxLength = 0;
            int left = 0;
            Set<Character> seen = new HashSet<>();

            for (int right = 0; right < s.length(); right++) {
                Character currentChar = s.charAt(right);

                while (seen.contains(currentChar)) {
                    seen.remove(s.charAt(left));
                    left++;
                }
                seen.add(currentChar);
                maxLength = Math.max(maxLength, right - left + 1);
            }

            return maxLength;
        }
    }
}
