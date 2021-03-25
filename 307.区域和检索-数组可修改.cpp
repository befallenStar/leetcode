/*
 * @lc app=leetcode.cn id=307 lang=cpp
 *
 * [307] 区域和检索 - 数组可修改
 */

// @lc code=start
class NumArray
{
private:
    int *nums;
    int length;

public:
    NumArray(vector<int> &nums)
    {
        this->length = nums.size();
        this->nums = new int[this->length * 2];
        for (int i = this->length, j = 0; i < this->length * 2; i++, j++)
        {
            this->nums[i] = nums[j];
        }
        for (int i = this->length - 1; i >= 0; i--)
        {
            this->nums[i] = this->nums[i * 2] + this->nums[i * 2 + 1];
        }
    }

    void update(int index, int val)
    {
        index += this->length;
        this->nums[index] = val;
        while (index > 0)
        {
            int left = index;
            int right = index;
            if (index % 2 == 0)
                right++;
            else
                left--;
            this->nums[index / 2] = this->nums[left] + this->nums[right];
            index /= 2;
        }
    }

    int sumRange(int left, int right)
    {
        int sum = 0;
        left += this->length;
        right += this->length;
        while (left <= right)
        {
            if (left % 2 == 1)
            {
                sum += this->nums[left];
                left++;
            }
            if (right % 2 == 0)
            {
                sum += this->nums[right];
                right--;
            }
            left /= 2;
            right /= 2;
        }
        return sum;
    }
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray* obj = new NumArray(nums);
 * obj->update(index,val);
 * int param_2 = obj->sumRange(left,right);
 */
// @lc code=end
