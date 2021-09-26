import java.util.*;

/* 371. Sum of Two Integers */
public class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int isCarry = (a & b) << 1;
            a ^= b;
            b = isCarry;
        }
        return a;
    }
}