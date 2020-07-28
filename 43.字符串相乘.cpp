/*
 * @lc app=leetcode.cn id=43 lang=cpp
 *
 * [43] 字符串相乘
 */

// @lc code=start
class Solution {
public:
    string multiply(string num1, string num2) {
        if(num1=="0"||num2=="0")
            return "0";
        int l1=num1.size();
        int l2=num2.size();
        int res[l1+l2];
        for(int i=0;i<l1+l2;i++)
            res[i]=0;
        for(int i=l1-1;i>=0;i--)
            for(int j=l2-1;j>=0;j--)
                res[i+j+1]+=(num1[i]-'0')*(num2[j]-'0');
        for(int i=l1+l2-1;i>=1;i--){
            if(res[i]>9)
            {
                res[i-1]+=res[i]/10;
                res[i]=res[i]%10;
            }
        }
        int pos=res[0]==0?1:0;
        string result="";
        for(;pos<l1+l2;pos++)
            result+=res[pos]+'0';
        return result;
    }
};
// @lc code=end

