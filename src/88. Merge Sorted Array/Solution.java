import java.util.*;

public class Solution {

    /*public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }*/

    /*public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = 0, q = 0;
        int[] sorted = new int[m + n];
        int curNum;
        while (p < m || q < n) {
            if (p == m) curNum = nums2[q++];
            else if (q == n) curNum = nums1[p++];
            else if (nums1[p] < nums2[q]) curNum = nums1[p++];
            else curNum = nums2[q++];
            sorted[p + q - 1] = curNum;
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = sorted[i];
        }
    }*/

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1, q = n - 1;
        int index = m + n - 1;
        int curNum;
        while (p >= 0 || q >= 0) {
            if (p == -1) curNum = nums2[q--];
            else if (q == -1) curNum = nums1[p--];
            else if (nums1[p] < nums2[q]) curNum = nums2[q--];
            else curNum = nums1[p--];
            nums1[index--] = curNum;
        }
    }

}

