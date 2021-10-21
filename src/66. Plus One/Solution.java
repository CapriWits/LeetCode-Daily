import java.util.*;

/* 66. Plus One */
public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0)
                return digits;
        }
        // 99 999...这样的情况，手动进一
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }
}