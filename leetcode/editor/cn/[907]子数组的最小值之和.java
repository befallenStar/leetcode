//给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。 
//
// 由于答案可能很大，因此 返回答案模 10^9 + 7 。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,1,2,4]
//输出：17
//解释：
//子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。 
//最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。 
//
// 示例 2： 
//
// 
//输入：arr = [11,81,94,43,3]
//输出：444
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 3 * 10⁴ 
// 1 <= arr[i] <= 3 * 10⁴ 
// 
//
// 
// Related Topics 栈 数组 动态规划 单调栈 👍 287 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1000000007;
        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peekLast()]) {
                stack.removeLast();
            }
            prev[i] = stack.isEmpty() ? -1 : stack.peekLast();
            stack.offerLast(i);
        }
        stack.clear();
        int[] next = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peekLast()]) {
                stack.removeLast();
            }
            next[i] = stack.isEmpty() ? n : stack.peekLast();
            stack.offerLast(i);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (long) (i - prev[i]) * (next[i] - i) % MOD * arr[i] % MOD;
            sum %= MOD;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
