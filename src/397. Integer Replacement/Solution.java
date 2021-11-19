import java.util.*;

/* 397. Integer Replacement */
public class Solution {
    private Map<Long, Integer> map = new HashMap<>();

    public int integerReplacement(int n) {
        return DFS(n * 1L);
    }

    private int DFS(long n) {
        if (n == 1) return 0;
        if (map.containsKey(n)) return map.get(n);
        int res = n % 2 == 0 ? DFS(n >> 1) : Math.min(DFS(n + 1), DFS(n - 1));
        map.put(n, res + 1); // +1 为本次操作
        return res + 1;
    }
}