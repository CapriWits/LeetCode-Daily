/* 1219. Path with Maximum Gold */
public class Solution {

    private int m;
    private int n;
    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    private boolean[][] vis;
    private int[][] grid;

    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        vis = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    vis[i][j] = true;
                    res = Math.max(res, DFS(i, j));
                    vis[i][j] = false;
                }
            }
        }
        return res;
    }

    private int DFS(int x, int y) {
        int res = grid[x][y];
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 0 || vis[nx][ny]) continue;
            vis[nx][ny] = true;
            res = Math.max(res, grid[x][y] + DFS(nx, ny));
            vis[nx][ny] = false;
        }
        return res;
    }
}