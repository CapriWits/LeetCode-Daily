
import java.util.*;

/* 剑指 Offer 15. 二进制中1的个数 */
public class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}