package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode95 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] result = new List[n + 1];
        result[0] = new ArrayList<TreeNode>();
        if (n == 0) {
            return result[0];
        }

        result[0].add(null);
        for (int len = 1; len <= n; len++) {
            result[len] = new ArrayList<TreeNode>();
            for (int j = 0; j <= len - 1; j++) {
                for (TreeNode node2 : result[len - 1 - j]) {
                    for (TreeNode node1 : result[j]) {
                        TreeNode newNode = new TreeNode(j + 1);
                        newNode.left = node1;
                        newNode.right = cloneNode(node2, j + 1);
                        result[len].add(newNode);
                    }
                }
            }
        }
        return result[n];
    }

    private static TreeNode cloneNode(TreeNode n, int offset) {
        if (n == null) {
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = cloneNode(n.left, offset);
        node.right = cloneNode(n.right, offset);
        return node;
    }
}
