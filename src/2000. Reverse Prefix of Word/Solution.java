/* 2000. Reverse Prefix of Word */
public class Solution {
    public String reversePrefix(String word, char ch) {
        int n = word.length();
        int idx = word.indexOf(ch);
        if (idx < 0) return word;
        char[] ss = word.toCharArray();
        int l = 0, r = idx;
        while (l < r) {
            char tmp = ss[l];
            ss[l++] = ss[r];
            ss[r--] = tmp;
        }
        return new String(ss);
    }
}