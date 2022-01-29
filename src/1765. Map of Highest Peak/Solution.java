import java.util.ArrayDeque;
import java.util.Deque;

/* 1765. Map of Highest Peak */
public class Solution {

    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] res = new int[m][n];
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) queue.offer(new int[]{i, j});
                res[i][j] = isWater[i][j] == 1 ? 0 : -1;    // Land value initialize as -1
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                for (int[] dir : dirs) {
                    int curX = x + dir[0], curY = y + dir[1];
                    if (curX < 0 || curX >= m || curY < 0 || curY >= n || res[curX][curY] != -1) continue;
                    res[curX][curY] = res[x][y] + 1;
                    queue.offer(new int[]{curX, curY});
                }
            }
        }
        return res;
    }
}