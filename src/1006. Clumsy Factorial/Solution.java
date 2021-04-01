import java.util.*;

public class Solution {

    public int clumsy(int N) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(N);
        N--;
        int idx = 0; // memorize which num is calculating
        while (N > 0) {
            if (idx % 4 == 0)
                stack.push(stack.pop() * N);
            else if (idx % 4 == 1)
                stack.push(stack.pop() / N);
            else if (idx % 4 == 2)
                stack.push(N);
            else
                stack.push(-N);
            idx++;
            N--;
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

}

