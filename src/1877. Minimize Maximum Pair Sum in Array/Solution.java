import java.util.*;

/* 1877. Minimize Maximum Pair Sum in Array */
public class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n / 2; ++i) {
            res = Math.max(res, nums[i] + nums[n - 1 - i]);
        }
        return res;
    }
}