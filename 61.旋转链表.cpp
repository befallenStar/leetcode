/*
 * @lc app=leetcode.cn id=61 lang=cpp
 *
 * [61] 旋转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution
{
public:
    ListNode *rotateRight(ListNode *head, int k)
    {
        if (head == NULL || head->next == NULL)
            return head;
        int len = 1;
        ListNode *oldTail = head;
        for (; oldTail->next != NULL; len++)
        {
            oldTail = oldTail->next;
        }
        k %= len;
        oldTail->next = head;
        ListNode *newTail = head;
        for (int i = 0; i < len - k - 1; i++)
        {
            newTail = newTail->next;
        }
        ListNode *newHead = newTail->next;
        newTail->next = NULL;
        return newHead;
    }
};
// @lc code=end
