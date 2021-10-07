import java.util.*;

/* 434. Number of Segments in a String */
public class Solution {
    public int countSegments(String s) {
        String ss;
        int res = 0;
        if ((ss = s.trim()).equals("") || (res = ss.split("\\s+").length) >= 0)
            return res;
        return res;
    }
}