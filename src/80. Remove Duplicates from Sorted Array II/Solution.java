import java.util.*;

public class Solution {

    // HashMap
    /*public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i = 0;
        for (int num : nums) {
            int count = (int) map.getOrDefault(num, 0) + 1;
            map.put(num, count);
            if (count <= 2) {
                nums[i++] = num;
            }
        }
        return i;
    }*/

    //Double pointer
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

}

