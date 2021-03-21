import java.util.*;

public class Solution {

    public void setZeroes(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        boolean isRow0 = false, isCol0 = false;
        // 判断第0列是否存在 0，一旦存在则在后面会将这一列全部归0
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                isCol0 = true;
                break;
            }
        }
        // 同上判断第0行是否存在0
        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == 0) {
                isRow0 = true;
                break;
            }
        }
        // 标记好后第0列/行后，将作为判断内部矩阵是否存在0的标志数组
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 根据第0列/行记录的结果将对应行列进行归0操作
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 最后将第0列和行判断归0
        if (isCol0) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
        if (isRow0) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }
    }

}

