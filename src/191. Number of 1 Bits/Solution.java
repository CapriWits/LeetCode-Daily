import java.util.*;

public class Solution {

    public int hammingWeight(int n) {
        return Integer.bitCount(n); // Java api
    }

    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            n &= n - 1; // make binary type of n lastest 1-bit to 0-bit
            res++;
        }
        return res;
    }

}

