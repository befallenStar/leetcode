#
# @lc app=leetcode.cn id=179 lang=python3
#
# [179] 最大数
#

# @lc code=start
class Solution:
    def largestNumber(self, nums: List[int]) -> str:

        class LargerCompare(str):
            def __lt__(x, y):
                return x+y > y+x

        # map() make the list of int to be a list of str
        # key= recieves functions with one parameter or u can write a class to compare two parameters
        result = ''.join(sorted(map(str, nums), key=LargerCompare))
        return '0' if result[0] == '0' else result
# @lc code=end
