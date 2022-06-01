//一个 2D 网格中的 顶峰元素 是指那些 严格大于 其相邻格子(上、下、左、右)的元素。 
//
// 给你一个 从 0 开始编号 的 m x n 矩阵 mat ，其中任意两个相邻格子的值都 不相同 。找出 任意一个 顶峰元素 mat[i][j] 并 返回其
//位置 [i,j] 。 
//
// 你可以假设整个矩阵周边环绕着一圈值为 -1 的格子。 
//
// 要求必须写出时间复杂度为 O(m log(n)) 或 O(n log(m)) 的算法 
//
// 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: mat = [[1,4],[3,2]]
//输出: [0,1]
//解释: 3和4都是顶峰元素，所以[1,0]和[0,1]都是可接受的答案。
// 
//
// 示例 2: 
//
// 
//
// 
//输入: mat = [[10,20,15],[21,30,14],[7,16,32]]
//输出: [1,1]
//解释: 30和32都是顶峰元素，所以[1,1]和[2,2]都是可接受的答案。
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 500 
// 1 <= mat[i][j] <= 10⁵ 
// 任意两个相邻元素均不相等. 
// 
// Related Topics 数组 二分查找 分治 矩阵 👍 39 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] pos = {0, -1, 0, 1, 1, 0, -1, 0};
    public int m;
    public int n;

    public int[] findPeakGrid(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        return stepIn(mat, 0, 0);
    }

    public int[] stepIn(int[][] mat, int x, int y) {
        for (int i = 0; i < 8; i += 2) {
            int nextx = x + pos[i], nexty = y + pos[i + 1];
            if (nextx >= 0 && nextx < m && nexty >= 0 && nexty < n && mat[x][y] < mat[nextx][nexty])
                return stepIn(mat, nextx, nexty);
        }
        return new int[]{x, y};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
