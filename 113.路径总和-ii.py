#
# @lc app=leetcode.cn id=113 lang=python3
#
# [113] 路径总和 II
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        res, path = [], []

        def dfs(root: TreeNode, sum: int):
            if not root:
                return
            path.append(root.val)
            sum -= root.val
            if not root.left and not root.right and sum == 0:
                res.append(path[:])
            dfs(root.left, sum)
            dfs(root.right, sum)
            path.pop()
        dfs(root, sum)
        return res


# @lc code=end
