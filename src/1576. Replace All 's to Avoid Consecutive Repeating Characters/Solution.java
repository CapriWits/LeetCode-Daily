/* 1576. Replace All ?'s to Avoid Consecutive Repeating Characters */
public class Solution {
    public String modifyString(String s) {
        int n = s.length();
        char[] ch = s.toCharArray();
        for (int i = 0; i < n; i++) {
            for (char c = 'a'; c <= 'z' && ch[i] == '?'; c++) {
                if ((i - 1 >= 0 && ch[i - 1] == c) || (i + 1 < n && ch[i + 1] == c))
                    continue;
                ch[i] = c;
                break;
            }
        }
        return String.valueOf(ch);
    }
}