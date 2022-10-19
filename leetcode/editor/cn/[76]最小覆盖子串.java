//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 2204 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private Map<Character, Integer> target = new HashMap<>();
    private Map<Character, Integer> cur = new HashMap<>();

    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n < m)
            return "";
        for (int i = 0; i < m; i++)
            target.put(t.charAt(i), target.getOrDefault(t.charAt(i), 0) + 1);

        int max = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int ansl = -1, ansr = -1;
        while (right < n) {
            char tr = s.charAt(right);
            if (target.containsKey(tr))
                cur.put(tr, cur.getOrDefault(tr, 0) + 1);
            while (check() && left <= right) {
                if (right - left + 1 < max) {
                    max = right - left + 1;
                    ansl = left;
                    ansr = right + 1;
                }
                char tl = s.charAt(left);
                if (target.containsKey(tl))
                    cur.put(tl, cur.getOrDefault(tl, 0) - 1);
                left++;
            }
            right++;
        }
        return ansl == -1 ? "" : s.substring(ansl, ansr);
    }

    public boolean check() {
        for (char c : target.keySet()) {
            if (cur.getOrDefault(c, 0) < target.get(c))
                return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
