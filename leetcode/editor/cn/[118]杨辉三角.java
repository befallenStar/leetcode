//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
//
// Related Topics 数组 动态规划 👍 822 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<Integer> row = new ArrayList<>() {{
            add(1);
        }};
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 1) {
            ans.add(row);
            return ans;
        }
        ans = generate(numRows - 1);
        List<Integer> tmp = ans.get(numRows - 2);
        for (int i = 1; i < tmp.size(); i++) {
            row.add(tmp.get(i) + tmp.get(i - 1));
        }
        row.add(1);
        ans.add(row);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
