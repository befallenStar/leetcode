//一个机器人位于一个
// m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 
//
// 示例 1： 
// 
// 
//输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//输出：2
//解释：3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
//
// 示例 2： 
// 
// 
//输入：obstacleGrid = [[0,1],[0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == obstacleGrid.length 
// n == obstacleGrid[i].length 
// 1 <= m, n <= 100 
// obstacleGrid[i][j] 为 0 或 1 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 856 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] grid = new int[m+1][n+1];
        boolean flag = true;
        for (int i = m - 1; i >= 0; i--)
            if (flag && obstacleGrid[i][n - 1] == 0)
                grid[i][n - 1] = 1;
            else {
                grid[i][n - 1] = 0;
                flag = false;
            }
        flag = true;
        for (int i = n - 1; i >= 0; i--)
            if (flag && obstacleGrid[m - 1][i] == 0)
                grid[m - 1][i] = 1;
            else {
                grid[m - 1][i] = 0;
                flag = false;
            }
        if (m < 2 || n < 2)
            return grid[0][0];
        for (int i = m - 2; i >= 0; i--)
            for (int j = n - 2; j >= 0; j--)
                if (obstacleGrid[i][j] == 1)
                    grid[i][j] = 0;
                else
                    grid[i][j] = grid[i + 1][j] + grid[i][j + 1];
        return grid[0][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
