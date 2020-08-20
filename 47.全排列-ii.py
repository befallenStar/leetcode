#
# @lc app=leetcode.cn id=47 lang=python3
#
# [47] 全排列 II
#

# @lc code=start
class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        current = 0
        res = self.backtrack(nums, current)
        return res

    def backtrack(self, nums: List[int], current: int) -> List[List[int]]:
        tmp=nums.copy()
        res = []
        if current == len(tmp):
            res.append(tmp)
            return res
        current += 1
        res.extend(self.backtrack(tmp, current))
        current -= 1
        for i in range(current):
            if tmp[i] == tmp[current]:
                break
            tmp[i], tmp[current] = tmp[current], tmp[i]
            current += 1
            res.extend(self.backtrack(tmp, current))
            current -= 1
            tmp[i], tmp[current] = tmp[current], nums[i]
        return res
# @lc code=end
