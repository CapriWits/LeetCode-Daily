import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 884. Uncommon Words from Two Sentences */
public class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        String ss = s1 + " " + s2;
        String[] str = ss.split(" ");
        for (String s : str) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1)
                res.add(entry.getKey());
        }
        return res.toArray(new String[0]);
    }
}