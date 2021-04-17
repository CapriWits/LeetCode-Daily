import java.util.*;

public class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> treeSet = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            Long u = Long.valueOf(nums[i]);
            // find the max value <= 'u' from TreeSet(closest to 'u' and >= 'u')
            Long l = treeSet.floor(u);
            // find the min value >= 'u' from TreeSet(closest to 'u' and <= 'u')
            Long r = treeSet.ceiling(u);
            if (l != null && u - l <= t) return true;
            if (r != null && r - u <= t) return true;
            treeSet.add(u);
            // if sliding window size bigger than k, remove first element
            if (i >= k) treeSet.remove(Long.valueOf(nums[i - k]));
        }
        return false;
    }

}

