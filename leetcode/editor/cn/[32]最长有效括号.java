//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
//
// Related Topics 栈 字符串 动态规划 👍 2038 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n < 1)
            return 0;
        Deque<Integer> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (que.isEmpty() || s.charAt(que.peekLast()) == ')')
                que.offer(i);
            else {
                if (s.charAt(i) == ')')
                    que.pollLast();
                else
                    que.offer(i);
            }
        }
        int res = 0;
        int tmp = n;
        while (!que.isEmpty()) {
            res = Math.max(res, tmp - que.peekLast() - 1);
            tmp = que.pollLast();
        }
        res = Math.max(res, tmp - 0);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
