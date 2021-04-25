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

public class Solution {

    /**
     * Solution 1: inorder the BST and memorize the sequence, Refactoring new TreeNode list
     */
    /*public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        TreeNode dummyHead = new TreeNode(-1);
        TreeNode curNode = dummyHead;
        for (Integer nodeVal : list) {
            curNode.right = new TreeNode(nodeVal);
            curNode = curNode.right;
        }
        return dummyHead.right;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }*/

    /**
     * Solution 2: handle the BST while inordering BST
     */
    TreeNode tempNode;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummyHead = new TreeNode(-1);
        tempNode = dummyHead;
        inorder(root);
        return dummyHead.right;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        tempNode.right = root;
        root.left = null; // set left child null
        tempNode = root;
        inorder(root.right);
    }

}

