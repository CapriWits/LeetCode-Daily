/* 1614. Maximum Nesting Depth of the Parentheses */
public class Solution {
    public int maxDepth(String s) {
        int res = 0;
        for (int i = 0, cnt = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') cnt++;
            else if (s.charAt(i) == ')') cnt--;
            res = Math.max(res, cnt);
        }
        return res;
    }
}
