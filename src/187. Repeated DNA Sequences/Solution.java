import java.util.*;

/* 187. Repeated DNA Sequences */
public class Solution {
    private static int L = 10;

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0, n = s.length(); i <= n - L; i++) {
            String ss = s.substring(i, i + L);
            map.put(ss, map.getOrDefault(ss, 0) + 1);
            if (map.get(ss) == 2)
                res.add(ss);
        }
        return res;
    }
}