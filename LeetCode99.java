package leetcode;

import java.util.ArrayList;

public class LeetCode99 {

    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> nodeList = new ArrayList<>();
        nodeList = getList(root, nodeList);
        if (nodeList.size() == 0 || nodeList.size() == 1) {
            return;
        }
        for (int i = 0; i < nodeList.size() - 1; i++) {
            for (int j = i + 1; j < nodeList.size(); j++) {
                TreeNode n1 = nodeList.get(i);
                TreeNode n2 = nodeList.get(j);
                swapNodeVal(n1, n2);
                if ( !isValidBST(root)) {
                    swapNodeVal(n1, n2);
                } else {
                    return;
                }
            }
        }
//        for (TreeNode i : nodeList) {
//            for (TreeNode j : nodeList) {
//                if (i != j) {
//                    swapNodeVal(i, j);
//                }
//                if (!isValidBST(root)) {
//                    swapNodeVal(i, j);
//                }
//            }
//        }

    }

    public static ArrayList<TreeNode> getList(TreeNode root, ArrayList<TreeNode> ans) {
        ans.add(root);
        if (root.left != null) {
            ans = getList(root.left, ans);
        }
        if (root.right != null) {
            ans = getList(root.right, ans);
        }
        return ans;
    }

    public void swapNodeVal(TreeNode node1, TreeNode node2) {
        int n1v = node1.val;
        node1.val = node2.val;
        node2.val = n1v;
    }

    public boolean isValidBST(TreeNode root) {
        return ValidBST(root, 21474364700L, -214748364800L);
    }

    public boolean ValidBST(TreeNode root, long l, long r) {
        if (root.left == null && root.right == null) {
            return true;
        } else {
            if (root.left == null) {
                if (root.right.val <= root.val || root.right.val >= l) {
                    return false;
                } else {
                    return ValidBST(root.right, l, root.val);
                }

            } else if (root.right == null) {
                if (root.left.val >= root.val || root.left.val <= r) {
                    return false;
                } else {
                    return ValidBST(root.left, root.val, r);
                }

            } else {
                if (root.left.val >= root.val || root.left.val <= r || root.right.val <= root.val || root.right.val >= l) {
                    return false;
                } else {
                    return ValidBST(root.left, root.val, r) && ValidBST(root.right, l, root.val);
                }
            }

        }

    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        ArrayList<TreeNode> ans = new ArrayList<>();
        System.out.println(getList(n1, ans).get(0).val);
        System.out.println(getList(n1, ans).get(1).val);
        System.out.println(getList(n1, ans).get(2).val);
    }

}
