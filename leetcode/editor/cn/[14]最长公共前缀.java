//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 👍 2373 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer();
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        for (int i = 0; i < strs[0].length(); i++) {
            char tmp = strs[0].charAt(i);
            boolean flag = true;
            for (int j = 1; j < strs.length; j++)
                if (strs[j].charAt(i) != tmp)
                    flag = false;
            if (flag)
                sb.append(tmp);
            else
                break;
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
