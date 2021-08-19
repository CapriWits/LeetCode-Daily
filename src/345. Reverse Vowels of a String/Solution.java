import java.util.*;

/* 345. Reverse Vowels of a String */
public class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        int i = 0, j = n - 1;
        while (i < j) {
            while (i < n && !isValid(c[i]))
                i++;
            while (j >= 0 && !isValid(c[j]))
                j--;
            if (i < j) {
                swap(c, i++, j--);
            }
        }
        return String.valueOf(c);
    }

    private boolean isValid(char c) {
        return "aeiouAEIOU".indexOf(c) >= 0;
    }

    private void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}