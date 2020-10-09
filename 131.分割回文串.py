#
# @lc app=leetcode.cn id=131 lang=python3
#
# [131] 分割回文串
#

# @lc code=start
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []

        def backtrace(start: int, path):
            if start >= len(s):
                result.append(path[:])
                return
            for i in range(start, len(s)):
                if isPalindrome(start, i):
                    path.append(s[start:i+1])
                    backtrace(i+1, path)
                    path.pop()

        def isPalindrome(start: int, end: int) -> bool:
            while(start < end):
                if s[start] != s[end]:
                    return False
                start += 1
                end -= 1
            return True
        backtrace(0, [])
        return result
# @lc code=end
