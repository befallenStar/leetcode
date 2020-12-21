#
# @lc app=leetcode.cn id=241 lang=python3
#
# [241] 为运算表达式设计优先级
#

# @lc code=start
class Solution:
    def diffWaysToCompute(self, input: str) -> List[int]:
        if input.isdigit():
            return [int(input)]

        result = []
        for i, c in enumerate(input):
            if c in ['+', '-', '*']:
                left = self.diffWaysToCompute(input[:i])
                right = self.diffWaysToCompute(input[i+1:])
                for l in left:
                    for r in right:
                        if c == '+':
                            result.append(l+r)
                        if c == '-':
                            result.append(l-r)
                        if c == '*':
                            result.append(l*r)
        return result

# @lc code=end
