import java.util.*;

public class Solution {
    private int[] cnt = new int[10001]; // cnt[x] is number of x in array

    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int x : nums) {
            cnt[x]++;
            max = Math.max(max, x);
        }
        // f[i][0] -> not choose i. f[i][1] -> choose i
        int[][] f = new int[max + 1][2];
        for (int i = 1; i <= max; i++) {
            f[i][1] = f[i - 1][0] + i * cnt[i];
            f[i][0] = Math.max(f[i - 1][1], f[i - 1][0]);
        }
        return Math.max(f[max][0], f[max][1]);
    }
}

