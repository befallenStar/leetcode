/*
 * @lc app=leetcode.cn id=113 lang=cpp
 *
 * [113] 路径总和 II
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution
{
public:
    vector<vector<int>> res;
    vector<int> path;
    vector<vector<int>> pathSum(TreeNode *root, int sum)
    {
        dfs(root, sum);
        return res;
    }
    void dfs(TreeNode *root, int sum)
    {
        if (!root)
            return;
        path.emplace_back(root->val);
        sum -= root->val;
        if (!root->left && !root->right && sum == 0)
            res.emplace_back(path);
        dfs(root->left, sum);
        dfs(root->right, sum);
        path.pop_back();
    }
};
// @lc code=end
