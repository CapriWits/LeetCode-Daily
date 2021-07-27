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

/* 671. Second Minimum Node In a Binary Tree */
public class Solution {
    private int res;
    private int minVal;

    public int findSecondMinimumValue(TreeNode root) {
        res = -1;
        minVal = root.val;
        DFS(root);
        return res;
    }

    private void DFS(TreeNode node) {
        if (node == null) return;
        if (res != -1 && node.val >= res) return; // 已经更新res，不需要继续向下搜索
        if (node.val > minVal)
            res = node.val;
        DFS(node.left);
        DFS(node.right);
    }
}