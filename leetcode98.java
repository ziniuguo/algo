package leetcode;

import java.math.BigDecimal;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class leetcode98 {

    public static boolean isValidBST(TreeNode root) {
        return ValidBST(root, 21474364700L, -214748364800L);
    }

    public static boolean ValidBST(TreeNode root, long l, long r) {
        if (root.left == null && root.right == null) {
            return true;
        } else {
            if (root.left == null) {
                if (root.right.val <= root.val || root.right.val>=l) {
                    return false;
                } else {
                    return ValidBST(root.right, l, root.val);
                }

            } else if (root.right == null) {
                if (root.left.val >= root.val || root.left.val<=r) {
                    return false;
                } else {
                    return ValidBST(root.left, root.val, r);
                }

            } else {
                if (root.left.val >= root.val || root.left.val<=r || root.right.val <= root.val || root.right.val>=l) {
                    return false;
                } else {
                    return ValidBST(root.left,  root.val, r) && ValidBST(root.right, l,  root.val);
                }
            }

        }

    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(isValidBST(n1));
    }
}