import java.util.*;

/* 496. Next Greater Element I */
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] >= stack.peek())
                stack.pop();
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        int[] res = new int[m];
        for (int i = 0; i < m; i++)
            res[i] = map.get(nums1[i]);
        return res;
    }
}