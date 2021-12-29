//给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。 
//
// 
//
// 示例 1： 
//
// 输入：matrix =
//[
//  [0,1,1,1],
//  [1,1,1,1],
//  [0,1,1,1]
//]
//输出：15
//解释： 
//边长为 1 的正方形有 10 个。
//边长为 2 的正方形有 4 个。
//边长为 3 的正方形有 1 个。
//正方形的总数 = 10 + 4 + 1 = 15.
// 
//
// 示例 2： 
//
// 输入：matrix = 
//[
//  [1,0,1],
//  [1,1,0],
//  [1,1,0]
//]
//输出：7
//解释：
//边长为 1 的正方形有 6 个。 
//边长为 2 的正方形有 1 个。
//正方形的总数 = 6 + 1 = 7.
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 300 
// 1 <= arr[0].length <= 300 
// 0 <= arr[i][j] <= 1 
// 
// Related Topics 数组 动态规划 矩阵 👍 200 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < n; i++)
            res[m - 1][i] = matrix[m - 1][i];
        for (int i = 0; i < m; i++)
            res[i][n - 1] = matrix[i][n - 1];
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (matrix[i][j] == 1)
                    res[i][j] = Math.min(res[i + 1][j], Math.min(res[i][j + 1], res[i + 1][j + 1])) + 1;
                else
                    res[i][j] = 0;
            }
        }
        int sum = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                sum += res[i][j];
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
