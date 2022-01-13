/* 747. Largest Number At Least Twice of Others */
public class Solution {
    public int dominantIndex(int[] nums) {
        if (nums.length <= 1) return 0;
        int max = nums[0], secMax = Integer.MIN_VALUE, res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                secMax = max;
                max = nums[i];
                res = i;
            } else if (nums[i] > secMax) {
                secMax = nums[i];
            }
        }
        return max >= secMax * 2 ? res : -1;
    }
}
