package io.catroll.algo;


class LeetCode112 {
    public static boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null){
            return false;
        }

        return dfs(root, targetSum, 0);

    }

    public static boolean dfs(TreeNode node, int targetSum, int curr) {
        curr += node.val;
        if (curr == targetSum && node.left==null && node.right==null) {
            return true;
        } else {
            if (node.left != null && node.right != null) {
                return dfs(node.left, targetSum, curr) || dfs(node.right, targetSum, curr);

            } else if (node.left != null){
                return dfs(node.left, targetSum, curr);
            } else if (node.right != null) {
                return dfs(node.right, targetSum, curr);
            } else {
                return false;
            }

        }

    }

    public static void main(String[] args) {
        TreeNode t1 =  new TreeNode(1, new TreeNode(2), null);
        System.out.println(hasPathSum(t1, 1));
    }
}