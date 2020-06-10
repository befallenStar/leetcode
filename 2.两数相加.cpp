/*
 * @lc app=leetcode.cn id=2 lang=cpp
 *
 * [2] 两数相加
 */

// @lc code=start

// Definition for singly-linked list.
// struct ListNode
// {
//     int val;
//     ListNode *next;
//     ListNode(int x) : val(x), next(NULL) {}
// };

class Solution
{
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2)
    {
        ListNode *result = new ListNode(-1);
        ListNode *re = result;
        int sum = 0;
        while (l1 || l2)
        {
            sum += l1 ? l1->val : 0;
            sum += l2 ? l2->val : 0;
            result->next = new ListNode(sum % 10);
            sum = sum / 10;
            result = result->next;
            if (l1)
                l1 = l1->next;
            if (l2)
                l2 = l2->next;
        }
        if (sum)
            result->next = new ListNode(sum);
        return re->next;
    }
};
// @lc code=end
