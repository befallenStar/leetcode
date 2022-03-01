//给你一个二进制数组 nums ，你需要从中删掉一个元素。 
//
// 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。 
//
// 如果不存在这样的子数组，请返回 0 。 
//
// 
//
// 提示 1： 
//
// 输入：nums = [1,1,0,1]
//输出：3
//解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。 
//
// 示例 2： 
//
// 输入：nums = [0,1,1,1,0,1,1,0,1]
//输出：5
//解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。 
//
// 示例 3： 
//
// 输入：nums = [1,1,1]
//输出：2
//解释：你必须要删除一个元素。 
//
// 示例 4： 
//
// 输入：nums = [1,1,0,0,1,1,1,0,1]
//输出：4
// 
//
// 示例 5： 
//
// 输入：nums = [0,0,0]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// nums[i] 要么是 0 要么是 1 。 
// 
// Related Topics 数学 动态规划 滑动窗口 👍 51 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubarray(int[] nums) {
        List<Integer> zeros = new ArrayList<>();
        zeros.add(-1);
        for (int i = 0; i < nums.length; i++) {
            if (0 == nums[i])
                zeros.add(i);
        }
        zeros.add(nums.length);
        if (zeros.size() < 3)
            return zeros.get(1) - zeros.get(0) - 2;
        int max = 0;
        for (int i = 0; i < zeros.size() - 2; i++) {
            int tmp = zeros.get(i + 2) - zeros.get(i) - 2;
            if (tmp > max)
                max = tmp;
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
