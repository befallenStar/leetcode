/*
 * @lc app=leetcode.cn id=103 lang=cpp
 *
 * [103] 二叉树的锯齿形层次遍历
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
class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> res;
        if(!root) return res;
        deque<TreeNode*> nodes;
        nodes.push_back(root);
        bool order=true;
        TreeNode* tmp;
        while(!nodes.empty()){
            int s=nodes.size();
            vector<int> floor;
            while(s){
                if(order){
                    tmp=nodes.front();
                    nodes.pop_front();
                    if(tmp->left) nodes.push_back(tmp->left);
                    if(tmp->right) nodes.push_back(tmp->right);
                }else{
                    tmp=nodes.back();
                    nodes.pop_back();
                    if(tmp->right) nodes.push_front(tmp->right);
                    if(tmp->left) nodes.push_front(tmp->left);
                }
                floor.push_back(tmp->val);
                s--;
            }
            order=!order;
            res.push_back(floor);
        }
        return res;
    }
};
// @lc code=end

