/*
 * @lc app=leetcode.cn id=89 lang=cpp
 *
 * [89] 格雷编码
 */

// @lc code=start
class Solution {
public:
    vector<int> grayCode(int n) {
        if(n==0)
            return vector<int>(1,0);
        if(n==1){
            vector<int> result(pow(2,n),0);
            result[0]=0;
            result[1]=1;
            return result;
        }
        vector<int> result=grayCode(n-1);
        for(int i=result.size()-1;i>=0;i--){
            result.push_back(result[i]+pow(2,n-1));
        }
        return result;
    }
};
// @lc code=end

