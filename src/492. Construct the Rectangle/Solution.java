import java.util.*;

/* 492. Construct the Rectangle */
public class Solution {
    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0)
            w--;
        return new int[]{area / w, w};
    }
}