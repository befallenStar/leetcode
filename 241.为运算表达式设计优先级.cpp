/*
 * @lc app=leetcode.cn id=241 lang=cpp
 *
 * [241] 为运算表达式设计优先级
 */

// @lc code=start
class Solution
{
public:
    vector<int> diffWaysToCompute(string input)
    {
        int num = 0;
        bool flag = true;
        vector<int> result;
        for (char c : input)
        {
            flag = isdigit(c);
            if (flag)
                num = num * 10 + (c - '0');
            else
                break;
        }
        if (flag)
        {
            result.push_back(num);
            return result;
        }
        for (int i = 0; i < input.size(); i++)
        {
            if ('+' == input[i] || '-' == input[i] || '*' == input[i])
            {
                vector<int> left = diffWaysToCompute(input.substr(0, i));
                vector<int> right = diffWaysToCompute(input.substr(i + 1, input.size()));
                for (int l : left)
                {
                    for (int r : right)
                    {
                        if ('+' == input[i])
                            result.push_back(l + r);
                        if ('-' == input[i])
                            result.push_back(l - r);
                        if ('*' == input[i])
                            result.push_back(l * r);
                    }
                }
            }
        }
        return result;
    }
};
// @lc code=end
