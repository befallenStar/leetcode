#
# @lc app=leetcode.cn id=137 lang=python3
#
# [137] 只出现一次的数字 II
#

# @lc code=start
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        X, Y = 0, 0
        for num in nums:
            Y = ~X & (Y ^ num)
            X = ~Y & (X ^ num)
        return Y
# @lc code=end
