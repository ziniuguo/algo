package io.catroll.algo;

public class leetcode111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 1);
    }

    public int dfs(TreeNode node, int ans) {


        int temp1 = ans, temp2 = ans;
        if (node.left != null) {
            temp1 = dfs(node.left, ans + 1);
        }
        if (node.right != null) {
            temp2 = dfs(node.right, ans + 1);
        }

        if (temp1 == ans) {
            return temp2;
        } else if (temp2 == ans) {
            return temp1;
        } else {
            return Math.min(temp1, temp2);
        }
    }
}
