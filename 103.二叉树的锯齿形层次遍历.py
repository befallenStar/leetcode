#
# @lc app=leetcode.cn id=103 lang=python3
#
# [103] 二叉树的锯齿形层次遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        res=[]
        if root is None: return res
        nodes=deque()
        nodes.append(root)
        order=True
        tmp=TreeNode()
        while len(nodes)!=0:
            s=len(nodes)
            floor=[]
            while s!=0:
                if order:
                    tmp=nodes.popleft()
                    if tmp.left: nodes.append(tmp.left)
                    if tmp.right: nodes.append(tmp.right)
                else:
                    tmp=nodes.pop()
                    if tmp.right: nodes.appendleft(tmp.right)
                    if tmp.left: nodes.appendleft(tmp.left)
                floor.append(tmp.val)
                s-=1
            order=not order
            res.append(floor)
        return res
# @lc code=end

