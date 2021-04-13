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

public class Solution {
    int res;
    int preVal;

    public int minDiffInBST(TreeNode root) {
        res = Integer.MAX_VALUE;
        preVal = -1;
        inorderTravelersal(root);
        return res;
    }

    private void inorderTravelersal(TreeNode root) {
        if (root == null) return;
        inorderTravelersal(root.left);
        if (preVal == -1) { // 到最左侧叶子结点再将preVal初始化
            preVal = root.val;
        } else {
            res = Math.min(res, root.val - preVal);
            preVal = root.val;
        }
        inorderTravelersal(root.right);
    }

}

