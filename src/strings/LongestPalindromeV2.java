package strings;

/**
 * Issue in https://leetcode.com/problems/longest-palindromic-substring/description/?envType=problem-list-v2&envId=string
 */
public class LongestPalindromeV2 {
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
            int maxLength = 0;
            int startIndex = 0;
            for (int i = 0; i < s.length(); i++) {
                // Trường hợp tâm lẻ
                int maxOdd = expandAroundCenter(s, i, i);
                if (maxLength < maxOdd) { // odd center
                    int half = Math.floorDiv(maxOdd, 2);
                    maxLength = maxOdd;
                    startIndex = i - half;
                }

                // Trường hợp tâm chẵn (Tâm giữa 2 số)
                int maxEven = expandAroundCenter(s, i, i + 1);
                if (maxLength < maxEven) { // odd center
                    int half = Math.floorDiv(maxEven, 2);
                    maxLength = maxEven;
                    startIndex = i - half + 1;
                }
            }

            return s.substring(startIndex, startIndex + maxLength);
        }

        private int expandAroundCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return right - left - 1;
        }
    }
}
