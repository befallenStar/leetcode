#
# @lc app=leetcode.cn id=31 lang=python3
#
# [31] 下一个排列
#

# @lc code=start
class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if len(nums) == 1:
            return
        max=nums[-1]
        left=-1
        for i in range(len(nums)-1,-1,-1):
            if nums[i] < max:
                left=i
                break
            else:
                max=nums[i]
        if left!=-1:
            right=len(nums)-1
            for i in range(left+1,len(nums)):
                if nums[i] <= nums[left]:
                    right=i-1
                    break
            self.swap(nums,left,right)
        self.reverse(nums,left+1)
    
    def swap(self,nums:List[int],left:int,right:int):
        nums[left],nums[right]=nums[right],nums[left]

    def reverse(self,nums:List[int],left:int):
        right=len(nums)-1
        while left<right:
            self.swap(nums,left,right)
            left+=1
            right-=1
# @lc code=end

