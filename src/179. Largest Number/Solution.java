import java.util.*;

public class Solution {

    public String largestNumber(int[] nums) {
        int len = nums.length;
        String[] numString = new String[len];
        for (int i = 0; i < len; i++) {
            numString[i] = String.valueOf(nums[i]);
        }
        // String array sort by descending
        Arrays.sort(numString, (a, b) -> {
            return (b + a).compareTo(a + b);
        });
        // if first element in sorted array equals "0", return 0
        if ("0".equals(numString[0])) return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(numString[i]);
        }
        return sb.toString();
    }

}

