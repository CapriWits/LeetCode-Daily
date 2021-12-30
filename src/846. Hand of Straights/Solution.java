import java.util.*;

/* 846. Hand of Straights */
public class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int x : hand) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            queue.add(x);
        }
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (map.get(x) == 0) continue;
            for (int i = 0; i < groupSize; i++) {
                int cur = map.getOrDefault(x + i, 0);
                if (cur == 0) return false;
                map.put(x + i, cur - 1);
            }
        }
        return true;
    }
}