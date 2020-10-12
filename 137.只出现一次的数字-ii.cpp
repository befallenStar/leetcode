/*
 * @lc app=leetcode.cn id=137 lang=cpp
 *
 * [137] 只出现一次的数字 II
 */

// @lc code=start
class Solution
{
public:
    int singleNumber(vector<int> &nums)
    {
        int X = 0, Y = 0;
        for (int num : nums)
        {
            Y = ~X & (Y ^ num);
            X = ~Y & (X ^ num);
        }
        return Y;
    }
};
// @lc code=end
