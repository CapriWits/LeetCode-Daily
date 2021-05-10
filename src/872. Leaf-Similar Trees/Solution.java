import java.util.;

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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> sequence1 = new ArrayList<>();
        List<Integer> sequence2 = new ArrayList<>();
        if (root1 != null) dfs(root1, sequence1);
        if (root2 != null) dfs(root2, sequence2);
        return sequence1.equals(sequence2);
    }

    private void dfs(TreeNode root, List<Integer> sequence) {
        if (root.left == null && root.right == null) {
            sequence.add(root.val);
        }
        if (root.left != null) dfs(root.left, sequence);
        if (root.right != null) dfs(root.right, sequence);
    }

}

