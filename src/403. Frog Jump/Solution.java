import java.util.*;

public class Solution {
    private Boolean[][] memo;

    public boolean canCross(int[] stones) {
        int n = stones.length;
        memo = new Boolean[n][n];
        return DFS(stones, 0, 0);
    }

    private boolean DFS(int[] stones, int i, int lastDis) {
        if (i == stones.length - 1) return true;
        if (memo[i][lastDis] != null) return memo[i][lastDis];

        for (int curDis = lastDis - 1; curDis <= lastDis + 1; curDis++) {
            if (curDis > 0) {
                int j = Arrays.binarySearch(stones, i + 1, stones.length, stones[i] + curDis);
                if (j >= 0 && DFS(stones, j, curDis)) {
                    return memo[i][lastDis] = true;
                }
            }
        }
        return memo[i][lastDis] = false;
    }

}

