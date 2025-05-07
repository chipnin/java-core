package strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Issue in https://leetcode.com/problems/longest-substring-without-repeating-characters/?envType=problem-list-v2&envId=string
 */
public class LongestSubstringV4 {
    public static void main(String[] args) {
        String[] testCases = {"abcabcbb", "bbbbb", "pwwkew", "au", " ", "   ", "abcadaedf"};
        for (String test : testCases) {
            Solution solution = new Solution();
            int longest = solution.lengthOfLongestSubstring(test);
            System.out.println("Input: " + test + " - Output: " + longest);
        }
    }

    /**
     * Using sliding window + index character
     */
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int maxLength = 0;
            int[] index = new int[256]; // sẽ chứa (index + 1) của kí tự trong window trùng xuất hiện cuối cùng
            int left = 0;

            for (int right = 0; right < s.length(); right++) {
                char currentChar = s.charAt(right);
                left = Math.max(left, index[currentChar] + 1);
                index[currentChar] = right + 1;

                maxLength = Math.max(maxLength, right - left + 1);
            }

            return maxLength;
        }
    }
}
