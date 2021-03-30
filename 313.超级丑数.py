#
# @lc app=leetcode.cn id=313 lang=python3
#
# [313] 超级丑数
#

# @lc code=start
class Solution:
    def nthSuperUglyNumber(self, n: int, primes: List[int]) -> int:
        k = len(primes)
        results = [1, ]
        resultIndex = [0]*k
        for i in range(1, n):
            ugly = min([primes[j]*results[resultIndex[j]] for j in range(k)])
            results.append(ugly)
            for j in range(k):
                if ugly == primes[j]*results[resultIndex[j]]:
                    resultIndex[j] += 1
        return results[-1]
# @lc code=end
