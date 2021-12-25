import java.util.ArrayDeque;
import java.util.Deque;

/* 1609. Even Odd Tree */
public class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int pre = level %2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if ((level % 2 == node.val % 2) || (level % 2 == 0 && pre >= node.val) || (level % 2 == 1 && pre <= node.val)) {
                    return false;
                }
                pre = node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            level++;
        }
        return true;
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

