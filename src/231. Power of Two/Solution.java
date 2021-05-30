import java.util.*;

/* 231. Power of Two */
public class Solution {
    /**
     * method1
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    /**
     * method2
     */
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (-n)) == n;
    }
}