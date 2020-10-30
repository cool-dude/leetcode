class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& nums) {
        map<int,vector<int>> x;
        for(int i=(int)nums.size()-1;i>=0;--i)
            for(int j=0;j<nums[i].size();++j)
                x[i+j].push_back(nums[i][j]);
        vector<int> o;
        for(auto&t:x)
            for(auto&u:t.second) o.push_back(u);
        return o;
    }
};