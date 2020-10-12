/*
 * @lc app=leetcode.cn id=139 lang=cpp
 *
 * [139] 单词拆分
 */

// @lc code=start
class Solution
{
public:
    bool wordBreak(string s, vector<string> &wordDict)
    {
        set<string> wordSet;
        for (string word : wordDict)
            wordSet.insert(word);
        vector<bool> dp = vector<bool>(s.size() + 1);
        dp[0] = true;
        for (int i = 1; i < s.size() + 1; i++)
            for (int j = 0; j < i; j++)
            {
                if (dp[j] && wordSet.find(s.substr(j, i - j)) != wordSet.end())
                {
                    dp[i] = true;
                    break;
                }
            }
        return dp[s.size()];
    }
};
// @lc code=end
