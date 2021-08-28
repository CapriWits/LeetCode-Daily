import java.util.*;

/* 1480. Running Sum of 1d Array */
public class Solution {
    public int[] runningSum(int[] nums) {
        int sum = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = (sum += nums[i]);
        }
        return nums;
    }
}