import java.util.*;

/* 520. Detect Capital */
public class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.toUpperCase().equals(word)) return true;
        if (word.toLowerCase().equals(word)) return true;
        int idx = 1, n = word.length();
        if (Character.isUpperCase(word.charAt(0))) {
            while (idx < n && Character.isLowerCase(word.charAt(idx)))
                idx++;
        }
        return idx == n;
    }
}