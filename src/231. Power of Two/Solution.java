import java.util.*;

public class Solution {

    /**
     * method 1
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        long x = (long) n;
        return (x & (x - 1)) == 0;
    }

    /**
     * method 2
     * @param n
     * @return
     */
    public boolean isPowerOfTwo2(int n) {
        if (n <= 0) return false;
        long x = (long) n;
        return (x & (-x)) == x;
    }

}

