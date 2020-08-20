/*
 * @lc app=leetcode.cn id=59 lang=cpp
 *
 * [59] 螺旋矩阵 II
 */

// @lc c ode=start
class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> result(n,vector<i nt>(n));
        int target=n*n;
        int number=1;
        int t=0,r=n-1,b= n-1,l= 0;
         while(number< =target){
             for(int i=l ;i<=r;i++) result[t][i]=number++;
            t++;
            for(int i=t ;i<=b;i++) result[i][r]=number++;
            r--;
            for(int i=r ;i>=l;i--) result[b][i]=number++;
            b--;
            for(int i=b ;i>=t;i--) result[i][l]=number++;
            l++;
        }
        return result;
    }
};
// @lc code=end

