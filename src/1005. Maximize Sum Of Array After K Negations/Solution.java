import java.util.Arrays;
import java.util.PriorityQueue;

/* 1005. Maximize Sum Of Array After K Negations */
public class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int n = nums.length, minIdx = 0;
        boolean hasZero = false;
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> nums[o1] - nums[o2])); // store negative num of Array_nums
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) queue.add(i);
            if (nums[i] == 0) hasZero = true;
            if (Math.abs(nums[i]) < Math.abs(nums[minIdx])) minIdx = i;
        }
        if (k <= queue.size()) {
            while (k-- > 0) nums[queue.peek()] = -nums[queue.poll()];
        } else { // k > number of negative number
            while (!queue.isEmpty() && k-- > 0) nums[queue.peek()] = -nums[queue.poll()];
            if (!hasZero && k % 2 != 0) nums[minIdx] = -nums[minIdx]; // not have zero && k % 2 != 0 -> make min num negative
        }
        return Arrays.stream(nums).sum();
    }
}