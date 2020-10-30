/*LC456:132 Pattern
https://leetcode.com/problems/132-pattern/
Given an array of n integers nums,
a 132 pattern is a subsequence of three
integers nums[i], nums[j] and nums[k]
such that i < j < k and nums[i] < nums[k] < nums[j].
Return true if there is a 132 pattern
in nums, otherwise, return false.
Follow up: The O(n^2) is trivial,
could you come up with the O(n logn)/O(n) solution?
Example 1:
Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.

Example 2:
Input: nums = [3,1,4,2]
Output: true
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].

Example 3:
Input: nums = [-1,3,2,0]
Output: true
Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].*/
class Sln{
    public boolean find132pattern(int[] nums){
        int n=nums.length,top=n,trd=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            if(nums[i]<trd) return true;
            while (top<n && nums[i]>nums[top]) trd=nums[top++];
            nums[--top]=nums[i];
        }
        return false;
    }
}