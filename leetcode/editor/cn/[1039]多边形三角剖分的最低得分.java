//给定 N，想象一个凸 N 边多边形，其顶点按顺时针顺序依次标记为 A[0], A[i], ..., A[N-1]。 
//
// 假设您将多边形剖分为 N-2 个三角形。对于每个三角形，该三角形的值是顶点标记的乘积，三角剖分的分数是进行三角剖分后所有 N-2 个三角形的值之和。 
//
// 返回多边形进行三角剖分后可以得到的最低分。 
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：[1,2,3]
//输出：6
//解释：多边形已经三角化，唯一三角形的分数为 6。
// 
//
// 示例 2： 
//
// 
//
// 输入：[3,7,4,5]
//输出：144
//解释：有两种三角剖分，可能得分分别为：3*7*5 + 4*5*7 = 245，或 3*4*5 + 3*4*7 = 144。最低分数为 144。
// 
//
// 示例 3： 
//
// 输入：[1,3,1,4,1,5]
//输出：13
//解释：最低分数三角剖分的得分情况为 1*1*3 + 1*1*4 + 1*1*5 + 1*1*1 = 13。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= A.length <= 50 
// 1 <= A[i] <= 100 
// 
// Related Topics 数组 动态规划 👍 104 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        for (int len = 1; len <= n; len++) {
            for (int l = 0; l < n - len + 1; l++) {
                int r = l + len - 1;
                if (len <= 2) dp[l][r] = 0;
                else {
                    for (int mid = l + 1; mid < r; mid++) {
                        dp[l][r] = Math.min(dp[l][r], dp[l][mid] + values[l] * values[mid] * values[r] + dp[mid][r]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
