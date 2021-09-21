import java.util.*;

/* 58. Length of Last Word */
public class Solution {
    public int lengthOfLastWord(String s) {
        String[] ss = s.replaceAll("\\s+", ",").split(",");
        return ss[ss.length - 1].length();
    }
}