//给你一个 m x n 的字符矩阵 box ，它表示一个箱子的侧视图。箱子的每一个格子可能为： 
//
// 
// '#' 表示石头 
// '*' 表示固定的障碍物 
// '.' 表示空位置 
// 
//
// 这个箱子被 顺时针旋转 90 度 ，由于重力原因，部分石头的位置会发生改变。每个石头会垂直掉落，直到它遇到障碍物，另一个石头或者箱子的底部。重力 不会 影
//响障碍物的位置，同时箱子旋转不会产生惯性 ，也就是说石头的水平位置不会发生改变。 
//
// 题目保证初始时 box 中的石头要么在一个障碍物上，要么在另一个石头上，要么在箱子的底部。 
//
// 请你返回一个 n x m的矩阵，表示按照上述旋转后，箱子内的结果。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：box = [["#",".","#"]]
//输出：[["."],
//      ["#"],
//      ["#"]]
// 
//
// 示例 2： 
//
// 
//
// 输入：box = [["#",".","*","."],
//            ["#","#","*","."]]
//输出：[["#","."],
//      ["#","#"],
//      ["*","*"],
//      [".","."]]
// 
//
// 示例 3： 
//
// 
//
// 输入：box = [["#","#","*",".","*","."],
//            ["#","#","#","*",".","."],
//            ["#","#","#",".","#","."]]
//输出：[[".","#","#"],
//      [".","#","#"],
//      ["#","#","*"],
//      ["#","*","."],
//      ["#",".","*"],
//      ["#",".","."]]
// 
//
// 
//
// 提示： 
//
// 
// m == box.length 
// n == box[i].length 
// 1 <= m, n <= 500 
// box[i][j] 只可能是 '#' ，'*' 或者 '.' 。 
// 
// Related Topics 数组 双指针 矩阵 👍 12 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] ans = new char[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(ans[i], '.');
        int cnt = 0;
        int pos = n - 1;
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j > -1; j--) {
                if (box[i][j] == '#') {
                    cnt++;
                } else if (box[i][j] == '*') {
                    int col = m - i - 1;
                    while (pos > j && cnt > 0) {
                        ans[pos--][col] = '#';
                        cnt--;
                    }
                    ans[j][col] = '*';
                    pos = j - 1;
                    cnt = 0;
                }
            }
            int col = m - i - 1;
            while (pos >= 0 && cnt > 0) {
                ans[pos--][col] = '#';
                cnt--;
            }
            pos = n - 1;
            cnt = 0;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
