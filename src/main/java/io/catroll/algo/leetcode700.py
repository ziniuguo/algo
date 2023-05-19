import TreeNode


class Solution:
    def searchBST(self, root, val):
        """
        :type root: TreeNode
        :type val: int
        :rtype: TreeNode
        """
        if root and val < root.val:
            return self.searchBST(root.left, val)
        elif root and val > root.val:
            return self.searchBST(root.right, val)
        return root