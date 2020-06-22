#
# @lc app=leetcode.cn id=3 lang=python3
#
# [3] 无重复字符的最长子串
#

# @lc code=start
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0
        if len(s) == 1:
            return 1
        length = 1
        left = 0
        right = 1
        se = {s[left]}
        while right < len(s):
            if s[right] in se:
                se.discard(s[left])
                left += 1
            else:
                se.add(s[right])
                right += 1
            max = right-left
            length = length if length > max else max
        return length
# @lc code=end
