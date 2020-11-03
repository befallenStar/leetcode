#
# @lc app=leetcode.cn id=199 lang=python3
#
# [199] 二叉树的右视图
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from queue import Queue


class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        right_side_view = {}
        q = Queue(maxsize=0)
        q.put([root, 0])
        max_depth = -1
        while not q.empty():
            node, depth = q.get()
            if node:
                max_depth = max(max_depth, depth)
                right_side_view[depth] = node.val
                q.put([node.left, depth+1])
                q.put([node.right, depth+1])
        return [right_side_view[depth] for depth in range(max_depth+1)]
# @lc code=end
