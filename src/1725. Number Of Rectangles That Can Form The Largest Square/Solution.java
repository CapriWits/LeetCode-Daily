/* 1725. Number Of Rectangles That Can Form The Largest Square */
public class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int res = 0, max = 0;
        for (int[] rectangle : rectangles) {
            int min = Math.min(rectangle[0], rectangle[1]);
            if (min > max) {
                max = min;
                res = 1;
            } else if (min == max) {
                res++;
            }
        }
        return res;
    }
}