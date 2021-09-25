import java.util.*;

/* 583. Delete Operation for Two Strings */
public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++) dp[i][0] = i;
        for(int j = 1; j <= n; j++) dp[0][j] = j;
        for (int i = 1; i <= m; i++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = word2.charAt(j - 1);
                dp[i][j] = c1 == c2 ? dp[i - 1][j - 1] : Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
            }
        }
        return dp[m][n];
    }
}
