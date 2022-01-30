//给你两个字符串 s1 和 s2 ，它们长度相等，请你检查是否存在一个 s1 的排列可以打破 s2 的一个排列，或者是否存在一个 s2 的排列可以打破 s1 
//的一个排列。 
//
// 字符串 x 可以打破字符串 y （两者长度都为 n ）需满足对于所有 i（在 0 到 n - 1 之间）都有 x[i] >= y[i]（字典序意义下的顺序
//）。 
//
// 
//
// 示例 1： 
//
// 输入：s1 = "abc", s2 = "xya"
//输出：true
//解释："ayx" 是 s2="xya" 的一个排列，"abc" 是字符串 s1="abc" 的一个排列，且 "ayx" 可以打破 "abc" 。
// 
//
// 示例 2： 
//
// 输入：s1 = "abe", s2 = "acd"
//输出：false 
//解释：s1="abe" 的所有排列包括："abe"，"aeb"，"bae"，"bea"，"eab" 和 "eba" ，s2="acd" 的所有排列包括：
//"acd"，"adc"，"cad"，"cda"，"dac" 和 "dca"。然而没有任何 s1 的排列可以打破 s2 的排列。也没有 s2 的排列能打破 s1 的排
//列。
// 
//
// 示例 3： 
//
// 输入：s1 = "leetcodee", s2 = "interview"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// s1.length == n 
// s2.length == n 
// 1 <= n <= 10^5 
// 所有字符串都只包含小写英文字母。 
// 
// Related Topics 贪心 字符串 排序 👍 20 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        int n = s1.length();
        int count = 0;
        while (count < n && c1[count] >= c2[count])
            count++;
        if (count == n)
            return true;
        count = 0;
        while (count < n && c1[count] <= c2[count])
            count++;
        return count == n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
