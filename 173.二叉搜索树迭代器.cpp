/*
 * @lc app=leetcode.cn id=173 lang=cpp
 *
 * [173] 二叉搜索树迭代器
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
class BSTIterator
{
private:
    vector<int> binaryTree;

public:
    void middleScan(TreeNode *root)
    {
        if (!root)
            return;
        middleScan(root->left);
        binaryTree.push_back(root->val);
        middleScan(root->right);
    }
    BSTIterator(TreeNode *root)
    {
        middleScan(root);
    }

    /** @return the next smallest number */
    int next()
    {
        int result = binaryTree[0];
        binaryTree.erase(binaryTree.begin());
        return result;
    }

    /** @return whether we have a next smallest number */
    bool hasNext()
    {
        return binaryTree.size();
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */
// @lc code=end
