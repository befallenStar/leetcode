#
# @lc app=leetcode.cn id=89 lang=python3
#
# [89] 格雷编码
#

# @lc code=start
class Solution:
    def grayCode(self, n: int) -> List[int]:
        if n==0:
            return [0]
        if n==1:
            return [0,1]
        result=self.grayCode(n-1)
        for i in range(len(result)-1,-1,-1):
            result.append(result[i]+2**(n-1))
        return result
# @lc code=end

