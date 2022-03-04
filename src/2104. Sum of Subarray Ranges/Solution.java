import java.util.ArrayDeque;
import java.util.Deque;

/* 2104. Sum of Subarray Ranges */
public class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[] minLeft = new int[n], minRight = new int[n];
        int[] maxLeft = new int[n], maxRight = new int[n];
        Deque<Integer> minStack = new ArrayDeque<>();
        Deque<Integer> maxStack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!minStack.isEmpty() && nums[minStack.peek()] > nums[i])
                minStack.pop();
            minLeft[i] = minStack.isEmpty() ? -1 : minStack.peek();
            minStack.push(i);
            // 如果 nums[maxStack.peek()] == nums[i], 那么根据定义，
            // nums[maxStack.peek()] 逻辑上小于 nums[i]，因为 maxStack.peek() < i
            while (!maxStack.isEmpty() && nums[maxStack.peek()] <= nums[i])
                maxStack.pop();
            maxLeft[i] = maxStack.isEmpty() ? -1 : maxStack.peek();
            maxStack.push(i);
        }
        maxStack.clear();
        minStack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!minStack.isEmpty() && nums[minStack.peek()] >= nums[i])
                minStack.pop();
            minRight[i] = minStack.isEmpty() ? n : minStack.peek();
            minStack.push(i);
            while (!maxStack.isEmpty() && nums[maxStack.peek()] < nums[i])
                maxStack.pop();
            maxRight[i] = maxStack.isEmpty() ? n : maxStack.peek();
            maxStack.push(i);
        }
        long maxSum = 0, minSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum += (long) (maxRight[i] - i) * (i - maxLeft[i]) * nums[i];
            minSum += (long) (minRight[i] - i) * (i - minLeft[i]) * nums[i];
        }
        return maxSum - minSum;
    }
}