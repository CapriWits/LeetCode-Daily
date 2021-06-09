import java.util.*;

/* 879. Profitable Schemes */
public class Solution {
    int mod = (int) 1e9 + 7;

    public int profitableSchemes(int n, int min, int[] gs, int[] ps) {
        int m = gs.length;
        long[][][] f = new long[m + 1][n + 1][min + 1];
        for (int i = 0; i <= n; i++) f[0][i][0] = 1;
        for (int i = 1; i <= m; i++) {
            int a = gs[i - 1], b = ps[i - 1];
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= min; k++) {
                    f[i][j][k] = f[i - 1][j][k];
                    if (j >= a) {
                        int u = Math.max(k - b, 0);
                        f[i][j][k] += f[i - 1][j - a][u];
                        f[i][j][k] %= mod;
                    }
                }
            }
        }
        return (int) f[m][n][min];
    }
}