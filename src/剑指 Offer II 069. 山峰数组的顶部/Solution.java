import java.util.*;

/* 剑指 Offer II 069. 山峰数组的顶部 */
public class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int l = 1, r = n - 2, res = 0;
        while (l <= r) {
            int mid = l + ((r - l) >>> 1);
            if (arr[mid] > arr[mid + 1]) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}