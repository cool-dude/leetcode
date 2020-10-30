/*LC41. First Missing Positive
https://leetcode.com/problems/first-missing-positive/
Given an unsorted integer array,
* find the smallest missing positive integer.
Example 1:
Input: [1,2,0]
Output: 3
Example 2:
Input: [3,4,-1,1]
Output: 2
Example 3:
Input: [7,8,9,11,12]
Output: 1*/
class Sln{
    public int firstMissingPositive(int[]  nums){
        int n=nums.length;
        for(int i=0;i<n;i++){
            while (nums[i]!=i+1){
                if(nums[i]<=0 || nums[i]>=n) {
                    break;
                }
                if(nums[i]==nums[nums[i]-1]){
                    break;
                }
                int t=nums[i];
                nums[i]=nums[t-1];
                nums[t-1]=t;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1)
                return i+1;
        }
        return n+1;
    }
    //T:O(N).
    //S:O(1).
}