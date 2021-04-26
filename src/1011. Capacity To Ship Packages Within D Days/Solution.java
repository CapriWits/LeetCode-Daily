import java.util.*;

public class Solution {

    public int shipWithinDays(int[] weights, int D) {
        int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
        while (left <= right) {
            int mid = (left + right) / 2; /** current weighting capacity */
            /** Days required & Total weigth per day */
            int needDays = 1, totalWeigthPerDay = 0;
            for (int weight : weights) {
                /** Too heavy, pass next day */
                if (totalWeigthPerDay + weight > mid) {
                    needDays++;
                    totalWeigthPerDay = 0;
                }
                totalWeigthPerDay += weight;
            }
            if (needDays <= D)
                right = mid - 1; /** reduce weight per day */
            else
                left = mid + 1; /** increase weigth per day */
        }
        return left;
    }

}

