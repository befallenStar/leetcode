/*
 * @lc app=leetcode.cn id=199 lang=cpp
 *
 * [199] 二叉树的右视图
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
    vector<int> rightSideView(TreeNode *root)
    {
        unordered_map<int, int> right_side_view;
        int max_depth = -1;
        queue<TreeNode *> nodes;
        queue<int> depths;
        nodes.push(root);
        depths.push(0);
        while (!nodes.empty())
        {
            TreeNode *node = nodes.front();
            nodes.pop();
            int depth = depths.front();
            depths.pop();
            if (node)
            {
                max_depth = max(max_depth, depth);
                right_side_view[depth] = node->val;
                nodes.push(node->left);
                nodes.push(node->right);
                depths.push(depth + 1);
                depths.push(depth + 1);
            }
        }
        vector<int> result;
        for (int i = 0; i <= max_depth; i++)
        {
            result.push_back(right_side_view[i]);
        }
        return result;
    }
};
// @lc code=end
