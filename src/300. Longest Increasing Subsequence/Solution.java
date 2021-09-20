import java.util.*;

/* 300. Longest Increasing Subsequence */
public class Solution {

    /**
     * dp[i] = max(dp[j]) + 1; 0 <= j < i && num[j] < num[i]
     */
    public int lengthOfLIS1(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    /**
     * tails：维护最长递增序列，但最终的数组未必是符合题意的，只取其长度作为结果
     * res：即作最长递增序列长度（结果），又作二分过程的右边界
     * 遍历数组，然后当前元素 num 如果大于tails里的最大元素，则可以直接插入进tails，对应最后需要让res++扩容
     * 如果 num 小于tails里的最大元素，就二分找到能插入的最前位置，把原来的元素替换掉，符合贪心思想
     */
    public int lengthOfLIS2(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int l = 0, r = res; // 确定好 tails 区间范围
            while (l < r) {
                int mid = l + ((r - l) >>> 1);
                if (num > tails[mid])
                    l = mid + 1;
                else
                    r = mid;
            }
            tails[l] = num; // 当前值替换二分找到的 l 位置
            if (res == r) res++; // 需要“扩容”
        }
        return res;
    }
}