import java.util.*;

/* 482. License Key Formatting */
public class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1, cnt = 0; i >= 0; i--) {
            if (s.charAt(i) == '-') continue;
            if (cnt == k && (cnt = 0) >= 0) sb.append("-"); // 正好为 k 个字符，计数器归零，加分隔符
            sb.append(Character.toUpperCase(s.charAt(i)));
            cnt++;
        }
        return sb.reverse().toString();
    }
}