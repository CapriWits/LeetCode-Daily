import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 1078. Occurrences After Bigram */
public class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] tt = text.split("\\s+");
        List<String> res = new ArrayList<>();
        for (int i = 0; i < tt.length - 2; i++) {
            if (tt[i].equals(first) && tt[i + 1].equals(second)) {
                res.add(tt[i + 2]);
            }
        }
        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String text = "we will we will rock you", first = "we", second = "will";
        String[] tt = new Solution().findOcurrences(text, first, second);
        Arrays.stream(tt).forEach(System.out::println);
    }
}