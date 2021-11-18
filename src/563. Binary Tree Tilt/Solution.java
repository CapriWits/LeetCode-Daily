import java.util.ArrayList;
import java.util.Arrays;

/* 563. Binary Tree Tilt */
public class Solution {
    private int res = 0;

    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        getSum(root);
        return res;
    }

    /**
     * 计算树节点总和的同时，记录坡度的总和
     */
    public int getSum(TreeNode root) {
        if (root == null) return 0;
        int l = getSum(root.left), r = getSum(root.right);
        res += Math.abs(l - r);
        return l + r + root.val;
    }
}

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