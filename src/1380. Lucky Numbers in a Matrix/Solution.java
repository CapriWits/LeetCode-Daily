import java.util.ArrayList;
import java.util.List;

/* 1380. Lucky Numbers in a Matrix */
public class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] row = new int[m], col = new int[n];
        for (int i = 0; i < m; i++) {
            row[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                row[i] = Math.min(row[i], matrix[i][j]);
                col[j] = Math.max(col[j], matrix[i][j]);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == row[i] && matrix[i][j] == col[j]) {
                    res.add(matrix[i][j]);
                }
            }
        }
        return res;
    }
}