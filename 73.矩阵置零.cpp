/*
 * @lc app=leetcode.cn id=73 lang=cpp
 *
 * [73] 矩阵置零
 */

// @lc code=start
class Solution
{
public:
    void setZeroes(vector<vector<int>> &matrix)
    {
        vector<int> rows;
        vector<int> cols;
        int m = matrix.size();
        int n = matrix[0].size();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (matrix[i][j] == 0)
                {
                    rows.push_back(i);
                    cols.push_back(j);
                }
        for (int row : rows)
            for (int i = 0; i < n; i++)
                matrix[row][i] = 0;
        for (int col : cols)
            for (int i = 0; i < m; i++)
                matrix[i][col] = 0;
    }
};
// @lc code=end
