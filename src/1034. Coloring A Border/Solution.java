import java.util.ArrayList;
import java.util.List;

/* 1034. Coloring A Border */
public class Solution {

    private int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private List<int[]> boarders = new ArrayList<>();
    private boolean[][] visited;
    private int m, n, originalColor;

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.originalColor = grid[row][col];
        visited = new boolean[m][n];
        DFS(grid, row, col);
        for (int[] boarder : boarders) {
            int x = boarder[0], y = boarder[1];
            grid[x][y] = color;
        }
        return grid;
    }

    private void DFS(int[][] grid, int x, int y) {
        boolean isBoarder = false;
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0], ny = y + dir[i][1];
            // 下一个位置是非连通分量
            if (!(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == originalColor)) {
                isBoarder = true;
                // break; // 不能 break，四个方向都要判断
            } else if (!visited[nx][ny]){
                visited[nx][ny] = true;
                DFS(grid, nx, ny);
            }
        }
        if (isBoarder) boarders.add(new int[]{x, y});
    }

}