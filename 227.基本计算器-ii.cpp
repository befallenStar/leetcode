/*
 * @lc app=leetcode.cn id=227 lang=cpp
 *
 * [227] 基本计算器 II
 */

// @lc code=start
class Solution
{
public:
    int calculate(string s)
    {
        int num = 0;
        char sign = '+';
        vector<int> stack;
        for (int i = 0; i <= s.size(); i++)
        {
            if (i == s.size() || s[i] == '+' || s[i] == '-' || s[i] == '*' || s[i] == '/')
            {
                if (sign == '+')
                {
                    stack.push_back(num);
                }
                else if (sign == '-')
                {
                    stack.push_back(-num);
                }
                else
                {
                    int current_num = stack.back();
                    stack.pop_back();
                    int value = 0;
                    if (sign == '*')
                        value = current_num * num;
                    if (sign == '/')
                        value = current_num / num;
                    stack.push_back(value);
                }
                num = 0;
                if (i < s.size())
                    sign = s[i];
            }
            else if (isdigit(s[i]))
                num = num * 10 + (s[i]-'0');
        }
        int sum=0;
        for(int i=0;i<stack.size();i++)
            sum+=stack[i];
        return sum;
    }
};
// @lc code=end
