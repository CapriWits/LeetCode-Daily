import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/* 373. Find K Pairs with Smallest Sums */
public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(k, (o1, o2) -> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            heap.offer(new int[]{i, 0});
        }
        while (k-- > 0 && !heap.isEmpty()) {
            int[] pair = heap.poll();
            res.add(new ArrayList<>(Arrays.asList(nums1[pair[0]], nums2[pair[1]])));
            if (pair[1] + 1 < nums2.length) {
                heap.offer(new int[]{pair[0], pair[1] + 1});
            }
        }
        return res;
    }
}