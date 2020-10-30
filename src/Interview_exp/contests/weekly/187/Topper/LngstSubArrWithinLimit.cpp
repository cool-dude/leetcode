/*LC1438: Longest Continuous Subarray Absolute Diff Less Than or Equal to Limit
https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
Given array of integers nums and an integer limit,
return the size of the longest continuous subarray
such that the absolute difference between any
two elements is less than or equal to limit.
In case there is no subarray satisfying the
given condition return 0.

Example 1:
Input: nums = [8,2,4,7], limit = 4
Output: 2
Therefore, the size of the longest subarray is 2.

Example 2:
Input: nums = [10,1,2,4,7,2], limit = 5
Output: 4
Explanation: The subarray [2,4,7,2] is the
longest since the maximum absolute diff is |2-7| = 5 <= 5.*/
class Solution {
public:
    int longestSubarray(vector<int>& nums, int limit) {
        multiset<int> cur;
        int n = nums.size();
        int ans = 0;
        for(int i = 0, j = 0; i < n; i++){
            while(j < n){
                if(cur.empty()) cur.insert(nums[j++]);
                else {
                    auto p = *cur.begin();
                    auto q = *prev(cur.end());
                    if(abs(p - q) <= limit) cur.insert(nums[j++]);
                    else break;
                }
            }
            if(!cur.empty()){
                auto p = *cur.begin();
                auto q = *prev(cur.end());
                if(abs(p - q) > limit)
                    cur.erase(cur.find(nums[--j]));
            }
            ans = max(ans, (int)cur.size());
            cur.erase(cur.find(nums[i]));
        }
        return ans;
    }
};