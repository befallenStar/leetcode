#
# @lc app=leetcode.cn id=223 lang=python3
#
# [223] 矩形面积
#

# @lc code=start
class Solution:
    def computeArea(self, A: int, B: int, C: int, D: int, E: int, F: int, G: int, H: int) -> int:
        def area(A: int, B: int, C: int, D: int):
            return (D-B)*(C-A)

        overlap = [A if A > E else E, B if B > F else F,
                   C if C < G else G, D if D < H else H]
        if overlap[0] >= overlap[2] or overlap[1] >= overlap[3]:
            overlap = [0, 0, 0, 0]
        result = area(A, B, C, D)+area(E, F, G, H)-area(*overlap)
        return result
# @lc code=end
