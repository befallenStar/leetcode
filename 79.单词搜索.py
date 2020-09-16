#
# @lc app=leetcode.cn id=79 lang=python3
#
# [79] 单词搜索
#

# @lc code=start
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if len(board)==0:
            return False
        for i in range(len(board)):
            for j in range(len(board[0])):
                if self.backtrack(board,word,i,j,0):
                    return True
        return False

    def backtrack(self,board:List[List[str]],word:str,i:int,j:int,k:int)->bool:
        if i<0 or i>=len(board) or j<0 or j>=len(board[0]) or board[i][j]!=word[k]:
            return False
        if k==len(word)-1 and word[k]==board[i][j]:
            return True
        temp=board[i][j]
        board[i][j]='\0'
        if self.backtrack(board,word,i+1,j,k+1)\
        or self.backtrack(board,word,i,j+1,k+1)\
        or self.backtrack(board,word,i-1,j,k+1)\
        or self.backtrack(board,word,i,j-1,k+1):
            return True
        board[i][j]=temp
        return False

# @lc code=end

