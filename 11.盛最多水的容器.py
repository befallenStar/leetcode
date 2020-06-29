#
# @lc app=leetcode.cn id=11 lang=python3
#
# [11] 盛最多水的容器
#

# @lc code=start
class Solution:
    def maxArea(self, height: List[int]) -> int:
        left = 0
        right = len(height)-1
        max = 0
        while left < right:
            h = height[left] if height[left] < height[right] else height[right]
            v = (right-left)*h
            max = v if v > max else max
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        return max
# @lc code=end
