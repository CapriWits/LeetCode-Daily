import java.util.List;
import java.util.PriorityQueue;

/* 539. Minimum Time Difference */
public class Solution {
    public int findMinDifference(List<String> timePoints) {
        // pigeonhole theorem
        if (timePoints.size() > 24 * 60) return 0;
        PriorityQueue<String> heap = new PriorityQueue();
        for (String timePoint : timePoints) {
            heap.offer(timePoint);
        }
        int pre = calMinutes(heap.poll());
        int start = pre, end = 0;
        int res = Integer.MAX_VALUE;
        while (!heap.isEmpty()) {
            int cur = calMinutes(heap.poll());
            res = Math.min(res, cur - pre);
            pre = cur;
            if (heap.isEmpty()) end = cur;
        }
        return Math.min(res, start + 24 * 60 - end);
    }

    /**
     * calculate minutes from 00:00 to current time
     *
     * @param curTime e.g. 16:24
     * @return minutes from 00:00 to current time
     */
    private int calMinutes(String curTime) {
        int hour = Integer.parseInt(curTime.substring(0, 2));
        int minutes = Integer.parseInt(curTime.substring(3));
        return hour * 60 + minutes;
    }

}