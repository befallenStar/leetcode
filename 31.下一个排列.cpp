/*
 * @lc app=leetcode.cn id=31 lang=cpp
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution
{
public:
    void nextPermutation(vector<int> &nums)
    {
        if (nums.size() == 1)
            return;
        int max = nums.back();
        int left = -1;
        for (int i = nums.size() - 1; i >= 0; i--)
        {
            if (nums[i] < max)
            {
                left = i;
                break;
            }
            else
            {
                max = nums[i];
            }
        }
        if (left != -1)
        {
            int right = nums.size() - 1;
            for (int i = left + 1; i < nums.size(); i++)
            {
                if (nums[i] <= nums[left])
                {
                    right = i - 1;
                    break;
                }
            }
            swap(nums, left, right);
        }

        reverse(nums, left + 1);
    }
    void swap(vector<int> &nums, int left, int right)
    {
        nums[left] = nums[left] ^ nums[right];
        nums[right] = nums[right] ^ nums[left];
        nums[left] = nums[left] ^ nums[right];
    }
    void reverse(vector<int> &nums, int left)
    {
        for (int i = left, j = nums.size() - 1; i < j; i++, j--)
        {
            swap(nums, i, j);
        }
    }
};
// @lc code=end
