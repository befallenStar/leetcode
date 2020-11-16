#
# @lc app=leetcode.cn id=227 lang=python3
#
# [227] 基本计算器 II
#

# @lc code=start
class Solution:
    def calculate(self, s: str) -> int:
        num, sign, stack = 0, '+', []
        for i in range(len(s)+1):
            if i == len(s) or s[i] in '+-*/':
                if sign in '+-':
                    sign = 1 if sign == '+' else -1
                    stack.append(sign*num)
                else:
                    current_num = stack.pop(-1)
                    value = current_num*num if sign == '*' else int(current_num/num)
                    stack.append(value)
                num = 0
                if i < len(s):
                    sign = s[i]
            elif s[i].isdigit():
                num = num*10+int(s[i])
        return sum(stack)
# @lc code=end
