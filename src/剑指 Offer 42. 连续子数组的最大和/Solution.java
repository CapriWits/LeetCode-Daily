import java.util.*;

/* 剑指 Offer 42. 连续子数组的最大和 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int pre = 0, res = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            res = Math.max(res, pre);
        }
        return res;
    }
}