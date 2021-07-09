import java.util.*;

/* 面试题 17.10. 主要元素 */
public class Solution {
    public int majorityElement(int[] nums) {
        int candidate = -1;
        int cnt = 0;
        for (int num : nums) {
            if (cnt == 0) candidate = num;
            if (num == candidate) {
                cnt++;
            } else {
                cnt--;
            }
        }
        cnt = 0;
        for (int num : nums) {
            if (num == candidate) cnt++;
        }
        return cnt * 2 > nums.length ? candidate : -1;
    }
}