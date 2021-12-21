/* 1154. Day of the Year */
public class Solution {
    int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int dayOfYear(String date) {
        String[] ss = date.split("-");
        int year = Integer.parseInt(ss[0]), month = Integer.parseInt(ss[1]), day = Integer.parseInt(ss[2]);
        if ((year % 400 == 0) || (year % 100 != 0) && (year % 4 == 0)) {
            daysOfMonth[1]++;
        }
        int res = 0;
        for (int i = 0; i < month - 1; i++) {
            res += daysOfMonth[i];
        }
        return res + day;
    }
}