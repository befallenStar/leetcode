/*
 * @lc app=leetcode.cn id=313 lang=cpp
 *
 * [313] 超级丑数
 */

// @lc code=start
class Solution
{
public:
    int nthSuperUglyNumber(int n, vector<int> &primes)
    {
        vector<int> results;
        int k = primes.size();
        vector<int> resultIndex(k, 0);
        results.push_back(1);
        for (int i = 1; i < n; i++)
        {
            int ugly = INT_MAX;
            for (int j = 0; j < k; j++)
                ugly = min(ugly, primes[j] * results[resultIndex[j]]);
            results.push_back(ugly);
            for (int j = 0; j < k; j++)
                if (ugly == primes[j] * results[resultIndex[j]])
                    resultIndex[j]++;
        }
        return results[n - 1];
    }
};
// @lc code=end
