public class Solution {

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);
        return Math.max(robRange(nums, 0, len - 2), robRange(nums, 1, len - 1));
    }

    private int robRange(int[] nums, int start, int end) {
        int len = nums.length;
        int[] dp = new int[len + 2];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[end];
    }

    // space O(n)
    private int robRange2(int[] nums, int start, int end) {
        int len = nums.length;
        int pre = nums[start], cur = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = cur;
            cur = Math.max(pre + nums[i], cur);
            pre = temp;
        }
        return cur;
    }

}

