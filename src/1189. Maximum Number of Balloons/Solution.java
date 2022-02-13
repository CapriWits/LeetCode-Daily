/* 1189. Maximum Number of Balloons */
public class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] map = new int[5];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == 'b') map[0]++;
            else if (c == 'a') map[1]++;
            else if (c == 'l') map[2]++;
            else if (c == 'o') map[3]++;
            else if (c == 'n') map[4]++;
        }
        map[2] /= 2;
        map[3] /= 2;
        int res = map[0]++;
        for (int i = 0; i < 5; i++) {
            res = Math.min(res, map[i]);
        }
        return res;
    }
}