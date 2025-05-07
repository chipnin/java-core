package strings;

import java.util.Arrays;

/**
 * Issue in https://leetcode.com/problems/longest-common-subsequence/?envType=problem-list-v2&envId=string
 */
public class TrackLongestCommonSubsequence {
    public static void main(String[] args) {
        String[] testCasesText1 = {"akbcdef", "psnw" ,"bl", "abcabcbb", "babad", "cbbd", "au", "4ab1ba2"};
        String[] testCasesText2 = {"zabfbcdejf","vozsh" ,"yby", "abcacbb", "babd", "cbbd", "au", "4abba12"};
        for (int i = 0; i < testCasesText1.length; i++) {
            Solution solution = new Solution();
            String text1 = testCasesText1[i];
            String text2 = testCasesText2[i];
            String longest = solution.longestCommonSubsequence(text1, text2);
            System.out.printf("Longest common subsequence (text1: %s - text2: %s) : %s\n", text1, text2, longest);
        }
    }

    static class Solution {
        public String longestCommonSubsequence(String text1, String text2) {
            int len1 = text1.length();
            int len2 = text2.length();
            int[][] dp = new int[len1 + 1][len2 + 1]; // Lưu độ dài xâu chung dài nhất giữa i kí tự text1  và j ký tự text2
            String[][] dpText = new String[len1 + 1][len2 + 1]; // Lưu xâu chung dài nhất giữa i kí tự text1  và j ký tự text2
            for (int i = 0; i <= len1; i++) {
                for (int j = 0; j <= len2; j++) {
                    if (i == 0 || j == 0) {
                        dpText[i][j] = "";
                    } else {
                        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                            dp[i][j] = dp[i - 1][j - 1] + 1;
                            dpText[i][j] = dpText[i - 1][j - 1] + text1.charAt(i - 1);
                        } else {
                            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                            dpText[i][j] = dpText[i - 1][j].length() > dpText[i][j - 1].length() ? dpText[i - 1][j] : dpText[i][j - 1];
                        }
                    }
                }
            }

            return dpText[len1][len2];
        }
    }
}
