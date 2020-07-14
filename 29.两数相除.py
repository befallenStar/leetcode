#
# @lc app=leetcode.cn id=29 lang=python3
#
# [29] 两数相除
#

# @lc code=start
class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        if dividend == -2147483648:
            if divisor == -1:
                return 2147483647
            elif divisor == 1:
                return -2147483648
        sgn = (dividend > 0) ^ (divisor > 0)
        dividend = abs(dividend)
        divisor = abs(divisor)
        cnt = 0
        result = 0
        while dividend >= divisor:
            cnt += 1
            divisor <<= 1
        while cnt > 0 and dividend > 0:
            divisor >>= 1
            cnt -= 1
            if dividend >= divisor:
                dividend -= divisor
                result += 1 << cnt
        if sgn:
            result = -result
        if result >= 2147483648:
            return 2147483647
        return result
# @lc code=end
