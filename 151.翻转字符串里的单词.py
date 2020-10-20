#
# @lc app=leetcode.cn id=151 lang=python3
#
# [151] 翻转字符串里的单词
#

# @lc code=start
class Solution:
    def reverseWords(self, s: str) -> str:
        # list=[]
        # i=len(s)-1
        # while i>=0:
        #     if  s[i]==' ':
        #         i-=1
        #         continue
        #     j=i-1
        #     while j>=0 and s[j]!=' ':
        #         j-=1
        #     j+=1
        #     list.append(s[j:i+1])
        #     i=j-1
        # ss=''
        # for word in list:
        #     ss=ss+word+' '
        # return ss[:-1]
        return ' '.join(reversed(s.split()))

# @lc code=end
