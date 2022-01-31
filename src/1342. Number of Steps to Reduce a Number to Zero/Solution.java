/* 1342. Number of Steps to Reduce a Number to Zero */
public class Solution {
    public int numberOfSteps(int num) {
        int res = 0;
        while (num > 0 && ++res > 0) num = num % 2 == 0 ? num / 2 : num - 1;
        return res;
    }
}