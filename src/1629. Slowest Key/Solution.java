/* 1629. Slowest Key */
public class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char res = keysPressed.charAt(0);
        int maxTime = releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            char key = keysPressed.charAt(i);
            int time = releaseTimes[i] - releaseTimes[i - 1];
            if (time > maxTime || (maxTime == time && key > res)) {
                res = key;
                maxTime = time;
            }
        }
        return res;
    }
}
