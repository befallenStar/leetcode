/*
 * @lc app=leetcode.cn id=229 lang=cpp
 *
 * [229] 求众数 II
 */

// @lc code=start
class Solution
{
public:
    vector<int> majorityElement(vector<int> &nums)
    {
        if (nums.size() == 1)
            return nums;
        if (nums.size() == 2)
        {
            if (nums[0] == nums[1])
                return vector(1, nums[0]);
            else
                return nums;
        }
        int cand1 = nums[0];
        int cnt1 = 0;
        int cand2 = nums[0];
        int cnt2 = 0;
        for (int i = 0; i < nums.size(); i++)
        {
            if (cand1 == nums[i])
            {
                cnt1++;
                continue;
            }
            if (cand2 == nums[i])
            {
                cnt2++;
                continue;
            }
            if (cnt1 == 0)
            {
                cand1 = nums[i];
                cnt1++;
                continue;
            }
            if (cnt2 == 0)
            {
                cand2 = nums[i];
                cnt2++;
                continue;
            }
            cnt1--;
            cnt2--;
        }
        cnt1 = 0;
        cnt2 = 0;
        vector<int> res;
        for (int num : nums)
        {
            if (num == cand1)
                cnt1++;
            if (num == cand2)
                cnt2++;
        }
        if (cnt1 > nums.size() / 3)
            res.push_back(cand1);
        if (cnt2 > nums.size() / 3 && cand1 != cand2)
            res.push_back(cand2);
        return res;
    }
};
// @lc code=end
