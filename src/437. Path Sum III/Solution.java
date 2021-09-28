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

/* 437. Path Sum III */
public class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        int res = DFS(root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);
        return res;
    }

    private int DFS(TreeNode root, int targetSum) {
        int res = 0;
        if (root == null)
            return 0;
        int curVal = root.val;
        if (curVal == targetSum)
            res++;
        res += DFS(root.left, targetSum - curVal);
        res += DFS(root.right, targetSum - curVal);
        return res;
    }
}