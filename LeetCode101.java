package leetcode;

public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        return isSymTree(root.left, root.right);
    }
    public boolean isSymTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            return isSymTree(p.left, q.right) && isSymTree(p.right, q.left);
        } else {
            return false;
        }

    }
}
