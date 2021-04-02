import java.util.*;

public class Solution {

    // dynamic programming
    // Time O(n) Space O(n)
    /*public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        int[] rigthMax = new int[n];
        rigthMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rigthMax[i] = Math.max(height[i], rigthMax[i + 1]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(leftMax[i], rigthMax[i]) - height[i];
        }
        return res;
    }*/

    // Stack
    // Time O(n) Space O(n)
    /*public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty())
                    break;
                int left = stack.peek();
                int curWidth = i - left - 1;
                int curHeight = Math.min(height[left], height[i]) - height[top];
                res += curHeight * curWidth;
            }
            stack.push(i);
        }
        return res;
    }*/

    // Double pointer
    // Time O(n) Space O(1)
    /*public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        int res = 0;
        int leftMax = 0, rightMax = 0, left = 0, right = n - 1;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }*/

}

