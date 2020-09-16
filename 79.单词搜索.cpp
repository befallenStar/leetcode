/*
 * @lc app=leetcode.cn id=79 lang=cpp
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution
{
public:
    bool exist(vector<vector<char>> &board, string word)
    {
        if (board.size() == 0)
            return false;
        for (int i = 0; i < board.size(); i++)
            for (int j = 0; j < board[0].size(); j++)
                if (backtrack(i, j, 0, word, board))
                {
                    return true;
                }
        return false;
    }
    bool backtrack(int i, int j, int k, string &word, vector<vector<char>> &board)
    {
        if (i < 0 || i >= board.size() || j < 0 || j >= board[0].size()||board[i][j]!=word[k])
            return false;
        if (k == word.length() - 1 && word[k] == board[i][j])
            return true;
        char temp = board[i][j];
        board[i][j] = '\0';
        if (backtrack(i + 1, j, k + 1, word, board) || backtrack(i, j + 1, k + 1, word, board) || backtrack(i - 1, j, k + 1, word, board) || backtrack(i, j - 1, k + 1, word, board))
            return true;
        board[i][j] = temp;
        return false;
    }
};
// @lc code=end
