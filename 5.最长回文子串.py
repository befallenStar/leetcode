#
# @lc app=leetcode.cn id=5 lang=python3
#
# [5] 最长回文子串
#

# @lc code=start
class Solution:
    def longestPalindrome(self, s: str) -> str:
        if "" == s:
            return ""
        max = 1
        result = s[0:1]
        for i in range(len(s)):
            start = i
            end = self.longestRepeating(s, start)
            while start > 0 and end < len(s)-1 and s[start-1] == s[end+1]:
                start -= 1
                end += 1
            length = end-start+1
            if max < length:
                result = s[start: end+1]
                max = length
        return result

    def longestRepeating(self, s: str, start: int) -> int:
        end = start+1
        while end < len(s) and s[end] == s[start]:
            end += 1
        return end-1
# @lc code=end
