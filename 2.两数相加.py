#
# @lc app=leetcode.cn id=2 lang=python3
#
# [2] 两数相加
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        result = ListNode(-1)
        re = result
        sum = 0
        while None != l1 or None != l2:
            sum += l1.val if l1 else 0
            sum += l2.val if l2 else 0
            result.next = ListNode(sum % 10)
            sum = sum//10
            if l1:
                l1 = l1.next
            if l2:
                l2 = l2.next
            result = result.next
        if sum:
            result.next = ListNode(sum)
        return re.next
# @lc code=end
