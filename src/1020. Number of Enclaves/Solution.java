/* 1020. Number of Enclaves */
public class Solution {
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int m, n;
    private boolean[][] visited;

    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                DFS(grid, i, 0);
            }
            if (grid[i][n - 1] == 1) {
                DFS(grid, i, n - 1);
            }
        }
        for (int j = 1; j < n - 1; j++) {
            if (grid[0][j] == 1) {
                DFS(grid, 0, j);
            }
            if (grid[m - 1][j] == 1) {
                DFS(grid, m - 1, j);
            }
        }
        int res = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    res++;
                }
            }
        }
        return res;
    }

    private void DFS(int[][] grid, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0 || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        for (int[] dir : dirs) {
            DFS(grid, row + dir[0], col + dir[1]);
        }
    }
}