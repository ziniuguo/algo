package io.catroll.algo;

import java.util.ArrayList;

public class leetcode124 {
    public static int maxPathSum(TreeNode root) {
        ArrayList<Integer> ansList = new ArrayList<>();
        ansList.add(Integer.MIN_VALUE);
        dfs(root, ansList);
        System.out.println(ansList);
        return ansList.get(0);
    }

    public static int dfs(TreeNode node, ArrayList<Integer> ansList) {
        if (node.left == null && node.right == null) {
            int ret = node.val;
            if (ret > ansList.get(0)) {
                ansList.set(0, ret);
            }
            return ret;

        }
        if (node.left == null) {
            int ret = dfs(node.right, ansList);
            if (ret < 0) {
                if (node.val > ansList.get(0)) {
                    ansList.set(0, node.val);
                }
                return node.val;
            } else {
                if (ret + node.val > ansList.get(0)) {
                    ansList.set(0, ret + node.val);
                }
                return ret + node.val;
            }

        }
        if (node.right == null) {
            int ret = dfs(node.left, ansList);
            if (ret < 0) {
                if (node.val > ansList.get(0)) {
                    ansList.set(0, node.val);
                }
                return node.val;
            } else {
                if (ret + node.val > ansList.get(0)) {
                    ansList.set(0, ret + node.val);
                }
                return ret + node.val;
            }
        }
        int left = dfs(node.left, ansList);
        int right = dfs(node.right, ansList);
        int cond1 = left + node.val;
        int cond2 = right + node.val;
        int cond3 = left + right + node.val;
        int cond4 = node.val;
        int max1 = Math.max(cond1, cond2);
        int max2 = Math.max(cond3, cond4);
        int maxFinal = Math.max(max1, max2);
        if (maxFinal > ansList.get(0)) {
            ansList.set(0, maxFinal);
        }
        // return maxFinal;
        if (Math.max(left, right) < 0) {
            return node.val;
        } else {
            return Math.max(left, right) + node.val;
        }
    }

    public static void main(String[] args) {
//        TreeNode rootNode = new TreeNode(10,
//                new TreeNode(9), new TreeNode(20,
//                new TreeNode(-15), new TreeNode(-7)));
        TreeNode rootNode = new TreeNode(-1000, null, new TreeNode(-3));
        System.out.println(maxPathSum(rootNode));

    }
}
