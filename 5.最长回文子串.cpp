/*
 * @lc app=leetcode.cn id=5 lang=cpp
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution
{
public:
    string longestPalindrome(string s)
    {
        if ("" == s)
        {
            return "";
        }
        int max = 1;
        string result = s.substr(0, 1);
        for (int i = 0; i < s.length(); i++)
        {
            int start = i;
            int end = longestRepeating(s, start);
            while (start > 0 && end < s.length() - 1 && s[start - 1] == s[end + 1])
            {
                start--;
                end++;
            }
            int length = end - start + 1;
            if (max < length)
            {
                result = s.substr(start, length);
                max = length;
            }
        }
        return result;
    }
    int longestRepeating(string s, int start)
    {
        int end = start + 1;
        while (end < s.length() && s[end] == s[start])
            end++;
        return end - 1;
    }
};
// @lc code=end
