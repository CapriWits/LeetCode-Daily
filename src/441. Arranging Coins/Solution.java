import java.util.*;

/* 441. Arranging Coins */
public class Solution {
    public int arrangeCoins(int n) {
        return (int) ((Math.sqrt((long) 8 * n + 1) - 1) / 2);
    }
}