import java.util.*;

public class Solution {

    // O(n)
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int row = -1;
        for (int i = 0; i < m - 1; i++) {
            if (target >= matrix[i][0] && target < matrix[i + 1][0]) {
                row = i;
                break;
            }
        }
        if (row == -1) { // if row equals -1, try to search the last row
            row = m - 1;
        }
        for (int j = 0; j < n; j++) {
            if (matrix[row][j] == target)
                return true;
        }
        return false;
    }

    // O(logmn)
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int x = matrix[mid / n][mid % n];
            if (target < x) {
                high = mid - 1;
            } else if (target > x) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

}

