import java.util.*;

/* 223. Rectangle Area */
public class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        for (List<String> path : paths)
            map.put(path.get(0), path.get(1));
        String res = paths.get(0).get(0);
        while (map.containsKey(res))
            res = map.get(res);
        return res;
    }
}