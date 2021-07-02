import java.util.*;

/* 1833. Maximum Ice Cream Bars */
public class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res = 0;
        for (int i = 0; i < costs.length; i++) {
            int curCost = costs[i];
            if (coins >= curCost) {
                coins -= curCost;
                res++;
            } else {
                break;
            }
        }
        return res;
    }
}