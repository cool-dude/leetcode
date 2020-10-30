/*LC1413: Minimum Value to Get Positive Step by Step Sum
Given an array of integers nums, you start
with an initial positive value startValue.
In each iteration, you calculate the step by
step sum of startValue plus elements in nums (from left to right).
Return the minimum positive value of startValue
such that the step by step sum is never less than 1.

Example 1:
Input: nums = [-3,2,-3,4,2]
Output: 5
Explanation: If you choose startValue = 4,
in the third iteration your step by step sum is less than 1.

Example 2:
Input: nums = [1,2]
Output: 1
Explanation: Minimum start value should be positive.

Example 3:
Input: nums = [1,-2,-3]
Output: 5*/
class Solution {
public:
    int minStartValue(vector<int>& nums) {
        int u=0,s=0;
        for(int i=0;i<nums.size();++i){
            u+=nums[i];
            s=max(s,-u);
        }
        return s+1;
    }
};