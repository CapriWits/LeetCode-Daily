import java.util.*;

/* 229. Majority Element II */
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (Integer x : map.keySet()) {
            if (map.get(x) > nums.length / 3) {
                res.add(x);
            }
        }
        return res;
    }
}