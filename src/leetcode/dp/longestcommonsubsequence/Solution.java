package leetcode.dp.longestcommonsubsequence;

// 1143. Longest Common Subsequence
// https://leetcode.com/problems/longest-common-subsequence/description/
// Отличная лекция о НОП и НВП: https://www.youtube.com/watch?v=1KSaJSZpkLM
public class Solution {
    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        int len = longestCommonSubsequence(text1, text2);
        System.out.println("len = " + len);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }
}
