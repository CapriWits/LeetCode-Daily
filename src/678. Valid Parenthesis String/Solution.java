import java.util.*;

/* 678. Valid Parenthesis String */
public class Solution {
    public boolean checkValidString(String s) {
        int minCnt = 0, maxCnt = 0;
        for (int i = 0, n = s.length(); i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                minCnt++;
                maxCnt++;
            } else if (ch == ')') {
                minCnt = minCnt - 1 < 0 ? 0 : minCnt - 1;
                if (--maxCnt < 0)
                    return false;
            } else {
                minCnt = minCnt - 1 < 0 ? 0 : minCnt - 1;
                maxCnt++;
            }
        }
        return minCnt == 0;
    }
}