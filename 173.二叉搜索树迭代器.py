#
# @lc app=leetcode.cn id=173 lang=python3
#
# [173] 二叉搜索树迭代器
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class BSTIterator:

    def __init__(self, root: TreeNode):
        self.binaryTree = []

        def middleScan(root: TreeNode):
            if not root:
                return
            middleScan(root.left)
            self.binaryTree.append(root.val)
            middleScan(root.right)

        middleScan(root)

    def next(self) -> int:
        """
        @return the next smallest number
        """
        return self.binaryTree.pop(0)

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return bool(len(self.binaryTree))


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
# @lc code=end
