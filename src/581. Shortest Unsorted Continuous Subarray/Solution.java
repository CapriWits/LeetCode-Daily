import java.util.*;

/* 581. Shortest Unsorted Continuous Subarray */
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int leftMax = Integer.MIN_VALUE, left = -1;
        int rightMIN = Integer.MAX_VALUE, right = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (leftMax <= nums[i])
                leftMax = nums[i];
            else
                right = i;
            if (rightMIN >= nums[n - 1 - i])
                rightMIN = nums[n - 1 - i];
            else
                left = n - 1 - i;
        }
        return right == -1 ? 0 : right - left + 1;
    }
}