import java.util.Arrays;

/* 506. Relative Ranks */
public class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] medal = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        int n = score.length;
        String[] res = new String[n];
        int[][] sortArray = new int[n][2];
        for (int i = 0; i < n; i++) {
            sortArray[i][0] = score[i];
            sortArray[i][1] = i;
        }
        Arrays.sort(sortArray, (o1, o2) -> o2[0] - o1[0]);
        for (int i = 0; i < n; i++) {
            res[sortArray[i][1]] = i < 3 ? medal[i] : Integer.toString(i + 1);
        }
        return res;
    }
}