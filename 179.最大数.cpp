/*
 * @lc app=leetcode.cn id=179 lang=cpp
 *
 * [179] 最大数
 */

// @lc code=start
class Solution
{
public:
    static bool largerCmp(string x, string y)
    {
        return x + y > y + x;
    }
    string largestNumber(vector<int> &nums)
    {
        vector<string> strs;
        for (int num : nums)
        {
            strs.push_back(to_string(num));
        }
        sort(strs.begin(), strs.end(), largerCmp);
        string s = "";
        for (string str : strs)
        {
            s += str;
        }
        if (s[0] == '0')
            return "0";
        return s;
    }
};
// @lc code=end
