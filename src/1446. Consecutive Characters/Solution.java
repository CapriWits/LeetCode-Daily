/* 1446. Consecutive Characters */
public class Solution {
    public int maxPower(String s) {
        int cnt = 1, res = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1))
                res = Math.max(res, ++cnt);
            else
                cnt = 1;
        }
        return res;
    }
}