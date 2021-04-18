import java.util.*;

public class Solution {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;
        int fast = 1, slow = 0;
        while (fast < n) {
            if (nums[fast] == nums[slow]) {
                fast++;
                continue;
            } else {
                nums[++slow] = nums[fast];
            }
        }
        return slow;
    }

}

