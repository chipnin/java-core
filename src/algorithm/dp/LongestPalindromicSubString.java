package algorithm.dp;

/**
 * Issue in https://leetcode.com/problems/longest-palindromic-substring/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class LongestPalindromicSubString {
    public static void main(String[] args) {
        String[] testCasesText = {"babad" ,"cbbd", "abcabcbb", "babad", "cbbd", "au", "4ab1ba2", "ccc"};
        for (int i = 0; i < testCasesText.length; i++) {
            Solution solution = new Solution();
            String text = testCasesText[i];
            String longest = solution.longestPalindrome(text);
            System.out.printf("LongestPalindromicSubString (text: %s) : %s\n", text, longest);
        }
    }

    static class Solution {
        public String longestPalindrome(String text) {
            int len = text.length();
            if (len <= 1) {
                return text;
            }
            int start = 0;
            int end = 0;
            int[][] dp = new int[len][len]; // dp[i][j] default = 0
            for (int i = 0; i < len; i++) {
                dp[i][i] = 1;
            }
            for (int i = 0; i < len - 1; i++) {
                dp[i][i + 1] = text.charAt(i) == text.charAt(i + 1) ? 1 : 0;
                if (dp[i][i + 1] == 1 && end - start < 1) {
                    start = i;
                    end = i + 1;
                }
            }
            for (int subLen = 3; subLen <= len; subLen++) {
                for (int i = 0; i <= len - subLen; i++) {
                    int j = i + subLen - 1;
                    if (text.charAt(i) == text.charAt(j) && dp[i + 1][j - 1] == 1) {
                        dp[i][j] = 1;
                        if ((j - i) > (end - start)) {
                            start = i;
                            end = j;
                        }
                    }
                }
            }

            return text.substring(start, end + 1);
        }
    }
}
