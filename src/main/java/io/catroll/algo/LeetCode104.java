package io.catroll.algo;

public class LeetCode104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 1;
        return dfs(root, ans);
    }

    public int dfs(TreeNode node, int ans) {
        int temp1 = ans, temp2 = ans;
        if (node.left != null) {
            temp1 = dfs(node.left, ans + 1);
        }
        if (node.right != null) {
            temp2 = dfs(node.right, ans + 1);
        }
        return Math.max(temp1, temp2);
    }
}
