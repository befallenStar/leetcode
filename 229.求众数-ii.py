#
# @lc app=leetcode.cn id=229 lang=python3
#
# [229] 求众数 II
#

# @lc code=start
class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        if len(nums) == 1:
            return nums
        if len(nums) == 2:
            if nums[0] == nums[1]:
                return [nums[0]]
            else:
                return nums
        cand1, cnt1 = nums[0], 0
        cand2, cnt2 = nums[0], 0
        for i in range(len(nums)):
            if cand1 == nums[i]:
                cnt1 += 1
                continue
            if cand2 == nums[i]:
                cnt2 += 1
                continue
            if cnt1 == 0:
                cand1 = nums[i]
                cnt1 += 1
                continue
            if cnt2 == 0:
                cand2 = nums[i]
                cnt2 += 1
                continue
            cnt1 -= 1
            cnt2 -= 1

        cnt1, cnt2, res = 0, 0, []
        for num in nums:
            if num == cand1:
                cnt1 += 1
            if num == cand2:
                cnt2 += 1
        if cnt1 > len(nums)//3:
            res.append(cand1)
        if cnt2 > len(nums)//3:
            res.append(cand2)
        if len(res) == 2 and res[0] == res[1]:
            return [res[0]]
        return res

# @lc code=end
