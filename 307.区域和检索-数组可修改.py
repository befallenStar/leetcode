#
# @lc app=leetcode.cn id=307 lang=python3
#
# [307] 区域和检索 - 数组可修改
#

# @lc code=start
class NumArray:

    def __init__(self, nums: List[int]):
        self.length = len(nums)
        self.nums = [0 for _ in range(self.length*2)]
        for i in range(self.length):
            self.nums[i+self.length] = nums[i]
        for i in range(self.length-1, -1, -1):
            self.nums[i] = self.nums[i*2]+self.nums[i*2+1]

    def update(self, index: int, val: int) -> None:
        index += self.length
        self.nums[index] = val
        while index > 0:
            left = index
            right = index
            if index % 2 == 0:
                right += 1
            else:
                left -= 1
            self.nums[index//2] = self.nums[left]+self.nums[right]
            index //= 2

    def sumRange(self, left: int, right: int) -> int:
        sum = 0
        left += self.length
        right += self.length
        while left <= right:
            if left % 2 == 1:
                sum += self.nums[left]
                left += 1
            if right % 2 == 0:
                sum += self.nums[right]
                right -= 1
            left //= 2
            right //= 2
        return sum


# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# obj.update(index,val)
# param_2 = obj.sumRange(left,right)
# @lc code=end
