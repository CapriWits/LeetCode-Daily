import java.time.LocalDate;

/* 1185. Day of the Week */
public class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate localDate = LocalDate.of(year, month, day);
        String[] s = {null, "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        return s[localDate.getDayOfWeek().getValue()];
    }
}