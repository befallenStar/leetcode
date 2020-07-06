#
# @lc app=leetcode.cn id=19 lang=python3
#
# [19] 删除链表的倒数第N个节点
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        if not head.next and n is 1:
            return None
        newhead = ListNode(0)
        newhead.next = head
        left = newhead
        right = newhead
        for i in range(n):
            right = right.next
        while right.next:
            left = left.next
            right = right.next
        left.next = left.next.next
        return newhead.next

# @lc code=end
