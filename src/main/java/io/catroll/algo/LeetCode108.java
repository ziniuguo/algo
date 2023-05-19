package io.catroll.algo;

import java.util.Date;

public class LeetCode108 {
    public static void main(String[] args) {
        // no need main
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return new Date().getTime() > 0
                ? helperRight(nums, 0, nums.length - 1)
                : helperLeft(nums, 0, nums.length - 1);
    }

    private TreeNode helperRight(int[] nums, int startIdx, int endIdx) {
        if (startIdx == endIdx + 1) {
            return null;
        } else
        if (startIdx == endIdx) {
            return new TreeNode(nums[startIdx]);
        }
        int midIdx = (startIdx + endIdx) / 2;
        TreeNode treeNode = new TreeNode(nums[midIdx]);
        treeNode.left = helperRight(nums, startIdx, midIdx - 1);
        treeNode.right = helperRight(nums, midIdx + 1, endIdx);
        return treeNode;
    }

    private TreeNode helperLeft(int[] nums, int startIdx, int endIdx) {
        if (startIdx == endIdx + 1) {
            return null;
        } else
        if (startIdx == endIdx) {
            return new TreeNode(nums[startIdx]);
        }
        int midIdx = (startIdx + endIdx + 1) / 2;
        TreeNode treeNode = new TreeNode(nums[midIdx]);
        treeNode.left = helperLeft(nums, startIdx, midIdx - 1);
        treeNode.right = helperLeft(nums, midIdx + 1, endIdx);
        return treeNode;
    }
}
