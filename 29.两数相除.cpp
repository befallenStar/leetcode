/*
 * @lc app=leetcode.cn id=29 lang=cpp
 *
 * [29] 两数相除
 */

// @lc code=start
class Solution
{
public:
    int divide(int dividend, int divisor)
    {
        if (dividend == -2147483648)
            if (divisor == -1)
                return 2147483647;
            else if (divisor == 1)
                return -2147483648;
        bool sgn = (dividend > 0) ^ (divisor > 0); // 1表示结果为负
        long udividend = 2147483648;
        if (dividend != -2147483648)
        {
            udividend = abs(dividend);
        }
        long udivisor = abs(divisor);
        long cnt = 0;
        long result = 0;
        while (udividend >= udivisor)
        {
            cnt++;
            udivisor <<= 1;
        }
        while (cnt > 0 && udividend > 0)
        {
            udivisor >>= 1;
            cnt--;
            if (udividend >= udivisor)
            {
                udividend -= udivisor;
                result += 1 << cnt;
            }
        }
        if (result >= 2147483648)
            return 2147483647;
        if (sgn)
            result = -result;
        return result;
    }
};
// @lc code=end
