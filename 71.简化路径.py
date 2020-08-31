#
# @lc app=leetcode.cn id=71 lang=python3
#
# [71] 简化路径
#

# @lc code=start
class Solution:
    def simplifyPath(self, path: str) -> str:
        strs=path.split('/')
        result=[]
        for s in strs:
            if s=="" or s=='.':
                continue
            if s=='..' and len(result)!=0:
                result.pop()
            elif s!='..':
                result.append(s)
        res=''
        for s in result:
            res+='/'+s
        if len(result)==0:
            return '/'
        return res
# @lc code=end

