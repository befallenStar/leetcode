//把字符串 s 看作是“abcdefghijklmnopqrstuvwxyz”的无限环绕字符串，所以 s 看起来是这样的："...
//zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....". 
//
// 现在我们有了另一个字符串 p 。你需要的是找出 s 中有多少个唯一的 p 的非空子串，尤其是当你的输入是字符串 p ，你需要输出字符串 s 中 p 的不同
//的非空子串的数目。 
//
// 注意: p 仅由小写的英文字母组成，p 的大小可能超过 10000。 
//
// 
//
// 示例 1: 
//
// 
//输入: "a"
//输出: 1
//解释: 字符串 S 中只有一个"a"子字符。
// 
//
// 
//
// 示例 2: 
//
// 
//输入: "cac"
//输出: 2
//解释: 字符串 S 中的字符串“cac”只有两个子串“a”、“c”。.
// 
//
// 
//
// 示例 3: 
//
// 
//输入: "zab"
//输出: 6
//解释: 在字符串 S 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。.
// 
//
// 
// Related Topics 字符串 动态规划 👍 173 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findSubstringInWraproundString(String p) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++)
            map.put(p.charAt(i), 1);
        int v = 1;
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i) - p.charAt(i - 1) == -25)
                v++;
            else
                v = 1;
            map.put(p.charAt(i), Math.max(v, map.get(p.charAt(i))));
        }
        int sum = 0;
        for (int i : map.values())
            sum += i;
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
