/*152. Maximum Product Subarray
https://leetcode.com/problems/maximum-product-subarray/

Given an integer array nums, find the
contiguous subarray within an array
(containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2,
because [-2,-1] is not a subarray.
 */
class Sln{
    public int maxProduct(int[] nums){}
        int currMax=nums[0],prevMax=nums[0],currMin=nums[0],prevMin=nums[0];
        int Ans=nums[0];
        for(int i=1;i<nums.length;i++){
            currMax= Math.max(nums[i],Math.max(nums[i]*prevMax,nums[i]*prevMin));
            currMin=Math.min(nums[i],Math.min(nums[i]*prevMax,nums[i]*prevMin));
            Ans=Math.max(Ans,currMax);
            prevMin=currMin;
            prevMax=currMax;
        }
        return Ans;
    }
    //T:O(n).
}