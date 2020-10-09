/*
 * @lc app=leetcode.cn id=131 lang=cpp
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution
{
public:
    vector<vector<string>> result;
    vector<string> path;
    void backtrace(string s, int start)
    {
        if (start >= s.size())
        {
            result.push_back(path);
            return;
        }
        for (int i = start; i < s.size(); i++)
        {
            if (isPalindrome(s, start, i))
            {
                path.push_back(s.substr(start, i - start + 1));
            }
            else
            {
                continue;
            }
            backtrace(s, i + 1);
            path.pop_back();
        }
    }
    vector<vector<string>> partition(string s)
    {
        backtrace(s, 0);
        return result;
    }
    bool isPalindrome(string s, int start, int end)
    {
        for (; start < end; start++, end--)
            if (s[start] != s[end])
                return false;
        return true;
    }
};
// @lc code=end
