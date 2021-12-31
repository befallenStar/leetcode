//我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。 
//
// 请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。 
//
// 
//
// 示例 1： 
//
// 输出：low = 100, high = 300
//输出：[123,234]
// 
//
// 示例 2： 
//
// 输出：low = 1000, high = 13000
//输出：[1234,2345,3456,4567,5678,6789,12345]
// 
//
// 
//
// 提示： 
//
// 
// 10 <= low <= high <= 10^9 
// 
// Related Topics 枚举 👍 33 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int n = count(low), m = count(high);
        List<Integer> ans = new ArrayList<>();
        for (int i = n; i <= m; i++) {
            for (int j = 1; j + i <= 10; j++) {
                int tmp = 0;
                for (int k = j; k < j + i; k++)
                    tmp += k * (int) Math.pow(10, i + j - k - 1);
                if (tmp >= low && tmp <= high)
                    ans.add(tmp);
            }
        }
        return ans;
    }

    public int count(int num) {
        int cnt = 0;
        while (num > 0) {
            num /= 10;
            cnt++;
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
