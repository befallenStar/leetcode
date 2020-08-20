#
# @lc app=leetcode.cn id=61 lang=python3
#
# [61] 旋转链表
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        if head == None or head.next == None:
            return head
        length = 1
        oldTail = head
        while oldTail.next:
            length += 1
            oldTail = oldTail.next
        k %= length
        oldTail.next = head
        newTail = head
        for i in range(length-k-1):
            newTail = newTail.next
        newHead = newTail.next
        newTail.next = None
        return newHead

# @lc code=end
