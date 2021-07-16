import java.util.*;

/* 剑指 Offer 53 - I. 在排序数组中查找数字 I */
public class Solution {
    public int search(int[] nums, int target) {
        return BinarySearch(nums, target) - BinarySearch(nums, target - 1);
    }

    private int BinarySearch(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] <= target)
                i = mid + 1;
            else
                j = mid - 1;
        }
        return i;
    }
}