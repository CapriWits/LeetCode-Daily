import java.util.HashSet;
import java.util.Set;

/* 1763. Longest Nice Substring */
public class Solution {
    public String longestNiceSubstring(String s) {
        int n = s.length();
        String res = "";
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j - i + 1 > res.length() && check(s.substring(i, j + 1)))
                    res = s.substring(i, j + 1);
            }
        }
        return res;
    }

    private boolean check(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        for (char c : s.toCharArray()) {
            char a = Character.toUpperCase(c), b = Character.toLowerCase(c);
            if (!set.contains(a) || !set.contains(b)) return false;
        }
        return true;
    }
}