/*
 * @lc app=leetcode.cn id=3 lang=cpp
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution
{
public:
    int lengthOfLongestSubstring(string s)
    {
        if (s.length() == 0)
        {
            return 0;
        }
        if (s.length() == 1)
        {
            return 1;
        }
        int len = 1;
        int left = 0, right = 1;
        set<char> set;
        set.insert(s[0]);
        while (right < s.length())
        {
            if (set.count(s[right]))
            {
                set.erase(s[left]);
                left++;
            }
            else
            {
                set.insert(s[right]);
                right++;
            }
            int max = right - left;
            len = len > max ? len : max;
        }
        return len;
    }
};
// @lc code=end
