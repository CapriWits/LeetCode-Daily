import java.util.*;

/* 516. Longest Palindromic Subsequence */
public class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            char ii = s.charAt(i);
            for (int j = i + 1; j < n; j++) {
                char jj = s.charAt(j);
                dp[i][j] = ii == jj ? dp[i + 1][j - 1] + 2 : Math.max(dp[i][j - 1], dp[i + 1][j]);
            }
        }
        return dp[0][n - 1];
    }
}