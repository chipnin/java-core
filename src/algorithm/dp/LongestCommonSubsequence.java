package algorithm.dp;

/**
 * Issue in https://leetcode.com/problems/longest-common-subsequence/?envType=problem-list-v2&envId=string
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String[] testCasesText1 = {"psnw" ,"bl", "abcabcbb", "babad", "cbbd", "au", "4ab1ba2"};
        String[] testCasesText2 = {"vozsh" ,"yby", "abcacbb", "babd", "cbbd", "au", "4abba12"};
        for (int i = 0; i < testCasesText1.length; i++) {
            Solution solution = new Solution();
            String text1 = testCasesText1[i];
            String text2 = testCasesText2[i];
            int longest = solution.longestCommonSubsequence(text1, text2);
            System.out.printf("Longest common subsequence (text1: %s - text2: %s) : %d\n", text1, text2, longest);
        }
    }

    static class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int len1 = text1.length();
            int len2 = text2.length();
            int[][] dp = new int[len1 + 1][len2 + 1]; // Lưu độ dài xâu chung dài nhất giữa i kí tự text1  và j ký tự text2
            for (int i = 0; i <= len1; i++) {
                for (int j = 0; j <= len2; j++) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 0;
                    } else {
                        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                            dp[i][j] = dp[i - 1][j - 1] + 1;
                        }

                        if (text1.charAt(i - 1) != text2.charAt(j - 1)) {
                            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                        }
                    }
                }
            }

            return dp[len1][len2];
        }
    }
}
