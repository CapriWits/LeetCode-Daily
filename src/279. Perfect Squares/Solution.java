import java.util.*;

/* 279. Perfect Squares */
public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int curMin = Integer.MAX_VALUE;
            int j = 1;
            while (i - j * j >= 0) {
                curMin = Math.min(curMin, dp[i - j * j] + 1);
                j++;
            }
            dp[i] = curMin;
        }
        return dp[n];
    }
}