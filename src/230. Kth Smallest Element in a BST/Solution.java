import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/* 230. Kth Smallest Element in a BST */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) { // 中序遍历
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0)
                break;
            root = root.right;
        }
        return root.val;
    }
}