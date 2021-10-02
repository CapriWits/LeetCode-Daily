import java.util.*;

/* 405. Convert a Number to Hexadecimal */
public class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int r = num & 0xF; // 末 4 位为一组
            char c = r < 10 ? (char) (r + '0') : (char) (r - 10 + 'a');
            sb.append(c);
            num >>>= 4;
        }
        return sb.reverse().toString();
    }
}