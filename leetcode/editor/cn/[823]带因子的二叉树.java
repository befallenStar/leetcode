//给出一个含有不重复整数元素的数组 arr ，每个整数 arr[i] 均大于 1。 
//
// 用这些整数来构建二叉树，每个整数可以使用任意次数。其中：每个非叶结点的值应等于它的两个子结点的值的乘积。 
//
// 满足条件的二叉树一共有多少个？答案可能很大，返回 对 10⁹ + 7 取余 的结果。 
//
// 
//
// 示例 1: 
//
// 
//输入: arr = [2, 4]
//输出: 3
//解释: 可以得到这些二叉树: [2], [4], [4, 2, 2] 
//
// 示例 2: 
//
// 
//输入: arr = [2, 4, 5, 10]
//输出: 7
//解释: 可以得到这些二叉树: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2]. 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 1000 
// 2 <= arr[i] <= 10⁹ 
// arr 中的所有值 互不相同 
// 
// Related Topics 数组 哈希表 动态规划 👍 73 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int MOD = 1000000007;
        int n = arr.length;
        Arrays.sort(arr);
        long[] res = new long[n];
        Arrays.fill(res, 1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(arr[i], i);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (0 == arr[i] % arr[j]) {
                    int right = arr[i] / arr[j];
                    if (map.containsKey(right)) {
                        res[i] = (res[i] + res[j] * res[map.get(right)]) % MOD;
                    }
                }
            }
        }
        long ans = 0;
        for (long r : res)
            ans = (ans + r) % MOD;
        return (int) ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
