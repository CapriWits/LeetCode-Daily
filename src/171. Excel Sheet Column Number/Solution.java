import java.util.*;

/* 171. Excel Sheet Column Number */
public class Solution {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        int k = 1;
        int n = columnTitle.length();
        for (int i = n - 1; i >= 0; i--) {
            int cur = columnTitle.charAt(i) - 'A' + 1;
            res += k * cur;
            k *= 26;
        }
        return res;
    }
}