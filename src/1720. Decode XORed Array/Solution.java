import java.util.*;

public class Solution {
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length;
        // the last element in original array doesn't calculate,
        // so the array's length is the length of encoded array + 1
        int[] res = new int[n + 1];
        res[0] = first;
        for (int i = 1; i < n + 1; i++) {
            res[i] = res[i - 1] ^ encoded[i - 1];
        }
        return res;
    }
}

