import java.util.*;

/* 477. Total Hamming Distance */
public class Solution {

    public int totalHammingDistance(int[] nums) {
        int res = 0, n = nums.length;
        for (int i = 0; i < 30; i++) {
            int num_of_1_bit = 0;
            for (int num : nums) {
                num_of_1_bit += (num >> i) & 1;
            }
            res += num_of_1_bit * (n - num_of_1_bit);
        }
        return res;
    }

}