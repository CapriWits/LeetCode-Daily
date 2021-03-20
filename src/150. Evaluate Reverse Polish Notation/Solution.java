import java.util.*;

public class Solution {

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            String token = tokens[i];
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                Integer two = stack.pop();
                Integer one = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(one + two);
                        break;
                    case "-":
                        stack.push(one - two);
                        break;
                    case "*":
                        stack.push(one * two);
                        break;
                    case "/":
                        stack.push(one / two);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
}

