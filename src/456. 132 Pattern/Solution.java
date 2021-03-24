import java.util.*;

public class Solution {

    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] preMin = new int[n];  // 0 ~ i the smallest num
        preMin[0] = nums[0];
        for (int i = 1; i < n; i++)
            preMin[i] = Math.min(preMin[i - 1], nums[i]);
        // the stack store num bigger than preMin[i] and smaller than num[i]
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = n - 1; i >= 0; i--) { // from tail to head traversal update stack
            if (nums[i] > preMin[i]) {
                // peek num smaller than all front of num is illicit
                while (!stack.isEmpty() && stack.peek() <= preMin[i])
                    stack.pop();
                // judge whether find 132 pattern
                if (!stack.isEmpty() && stack.peek() < nums[i]) // 3(peek) < 2(num[i])
                    return true;
                stack.push(nums[i]);    // not find, push the num that smaller than preMin[i] into stack
            }
        }
        return false;
    }

}

