/* 1816. Truncate Sentence */
public class Solution {
    public String truncateSentence(String s, int k) {
        int n = s.length(), idx = 0;
        while (idx < n) {
            if (s.charAt(idx) == ' ' && --k == 0) break;
            idx++;
        }
        return s.substring(0, idx);
    }

}