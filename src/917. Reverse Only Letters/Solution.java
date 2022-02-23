/* 917. Reverse Only Letters */
public class Solution {
    public String reverseOnlyLetters(String s) {
        int n = s.length();
        char[] ss = s.toCharArray();
        int l = 0, r = n - 1;
        while (l < r) {
            while (l < r && !Character.isLetter(ss[l])) l++;
            while (l < r && !Character.isLetter(ss[r])) r--;
            char tmp = ss[l];
            ss[l] = ss[r];
            ss[r] = tmp;
            l++; r--;
        }
        return new String(ss);
    }
}