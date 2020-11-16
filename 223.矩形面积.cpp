/*
 * @lc app=leetcode.cn id=223 lang=cpp
 *
 * [223] 矩形面积
 */

// @lc code=start
class Solution
{
public:
    int computeArea(int A, int B, int C, int D, int E, int F, int G, int H)
    {
        long width = max((long)0, (long)min(G, C) - max(A, E));
        long height = max((long)0, (long)min(D, H) - max(B, F));
        return (int)((D - B) * (long)(C - A) + (H - F) * (G - E) - width * height);
    }
};
// @lc code=end
