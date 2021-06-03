import java.util.*;

/* 525. Contiguous Array */
public class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + (nums[i - 1] == 1 ? 1 : -1);
        }
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 2; i <= n; i++) {
            if (!map.containsKey(preSum[i - 2])) {
                map.put(preSum[i - 2], i - 2);
            }
            if (map.containsKey(preSum[i])) {
                res = Math.max(res, i - map.get(preSum[i]));
            }
        }
        return res;
    }
}