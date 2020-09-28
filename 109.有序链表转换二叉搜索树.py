#
# @lc app=leetcode.cn id=109 lang=python3
#
# [109] 有序链表转换二叉搜索树
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # def getMedian(self, left: ListNode, right: ListNode) -> ListNode:
    #     fast, slow = left, left
    #     while fast != right and fast.next != right:
    #         fast = fast.next.next
    #         slow = slow.next
    #     return slow

    def sortedListToBST(self, head: ListNode) -> TreeNode:
        def getLength(head: ListNode) -> int:
            length = 0
            while head:
                head = head.next
                length += 1
            return length

        def buildTree(left: int, right: int) -> TreeNode:
            if left > right:
                return None
            mid = (left+right)//2
            root = TreeNode()
            root.left = buildTree(left, mid-1)
            nonlocal head
            root.val = head.val
            head = head.next
            root.right = buildTree(mid+1, right)
            return root

        length = getLength(head)
        return buildTree(0, length-1)
# @lc code=end
