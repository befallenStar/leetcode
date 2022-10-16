//给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。 
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, k = 3
//输出："213"
// 
//
// 示例 2： 
//
// 
//输入：n = 4, k = 9
//输出："2314"
// 
//
// 示例 3： 
//
// 
//输入：n = 3, k = 1
//输出："123"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 1 <= k <= n! 
// 
//
// Related Topics 递归 数学 👍 720 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private final int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    public String getPermutation(int n, int k) {
        List<String> l = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            l.add(String.valueOf(i));
        return getPermutation(l, k - 1);
    }

    public String getPermutation(List<String> l, int k) {
        if (l.size() == 0)
            return "";
        int n = l.size();
        int index = k / factorial[n - 1];
        String res = l.get(index);
        l.remove(index);
        return res + getPermutation(l, k % factorial[n - 1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
