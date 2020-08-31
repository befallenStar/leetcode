/*
 * @lc app=leetcode.cn id=71 lang=cpp
 *
 * [71] 简化路径
 */

// @lc code=start
class Solution {
public:
    string simplifyPath(string path) {
        stringstream ss(path);
        string tmp="";
        vector<string> result;
        while(getline(ss,tmp,'/')){
            if(tmp==""||tmp==".")
                continue;
            if(tmp==".."&&!result.empty())
                result.pop_back();
            else if(tmp!="..")
                result.push_back(tmp);            
        }
        string res="";
        for(string str:result){
            res+="/"+str;
        }
        if(result.empty())
            return "/";
        return res;
    }
};
// @lc code=end

