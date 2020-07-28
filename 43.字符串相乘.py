#
# @lc app=leetcode.cn id=43 lang=python3
#
# [43] 字符串相乘
#

# @lc code=start
class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        if num1 == '0' or num2 == '0':
            return '0'
        l1 = len(num1)
        l2 = len(num2)
        res = [0]*(l1+l2)
        for i in range(l1-1, -1, -1):
            for j in range(l2-1, -1, -1):
                res[i+j+1] += int(num1[i])*int(num2[j])
        for i in range(l1+l2-1, 0, -1):
            if res[i] > 9:
                res[i-1] += res[i]//10
                res[i] = res[i] % 10
        pos = int(res[0] == 0)
        result = ""
        while pos < l1+l2:
            result += str(res[pos])
            pos += 1
        return result
# @lc code=end
