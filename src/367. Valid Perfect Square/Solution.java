import java.util.*;

/* 367. Valid Perfect Square */
public class Solution {
    public boolean isPerfectSquare(int num) {
        int l = 0, r = num;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            long square = (long) mid * mid;
            if (square < num) {
                l = mid + 1;
            } else if (square > num) {
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}