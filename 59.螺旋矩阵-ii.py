#
# @lc app=leetcode.cn id=59 lang=python3
#
# [59] 螺旋矩阵 II
#

# @lc code=start
class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        result=[[0 for _ in range(n)] for _ in range(n)]
        t,r,b,l=0,n-1,n-1,0
        number,target=1,n**2
        while number<=target:
            for i in range(l,r+1):
                result[t][i]=number
                number+=1
            t+=1
            for i in range(t,b+1):
                result[i][r]=number
                number+=1
            r-=1
            for i in range(r,l-1,-1):
                result[b][i]=number
                number+=1
            b-=1
            for i in range(b,t-1,-1):
                result[i][l]=number
                number+=1
            l+=1
        return result
# @lc code=end

