/*
 * @lc app=leetcode.cn id=151 lang=cpp
 *
 * [151] 翻转字符串里的单词
 */

// @lc code=start
class Solution
{
public:
    string reverseWords(string s)
    {
        reverse(s.begin(), s.end());
        int idx = 0;
        for (int start = 0; start < s.size(); start++)
        {
            if (s[start] != ' ')
            {
                if (idx != 0)
                    s[idx++] = ' ';
                int end = start;
                while (end < s.size() && s[end] != ' ')
                    s[idx++] = s[end++];
                reverse(s.begin() + idx - (end - start), s.begin() + idx);
                start = end;
            }
        }
        s.erase(s.begin() + idx, s.end());
        return s;
    }
};
// @lc code=end
