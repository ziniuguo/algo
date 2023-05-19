package io.catroll.algo;

import java.util.ArrayList;
import java.util.List;

public class LeetCode94 {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        return Traversal(root, result);
    }

    public List<Integer> Traversal(TreeNode root, List<Integer> ls) {

        if (root.left == null && root.right == null) {
            ls.add(root.val);
            return ls;
        } else {
            if (root.right == null) {
                Traversal(root.left, ls);
                ls.add(root.val);
            } else if (root.left == null) {
                ls.add(root.val);
                Traversal(root.right, ls);
            } else {
                Traversal(root.left, ls);
                ls.add(root.val);
                Traversal(root.right, ls);
            }
        }
        return ls;
    }
}
