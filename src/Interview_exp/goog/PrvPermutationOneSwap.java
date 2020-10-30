/*1053. Previous Permutation With One Swap
https://leetcode.com/problems/previous-permutation-with-one-swap/
Given an array A of positive integers (not
necessarily distinct), return the lexicographically
largest permutation that is smaller than A,
that can be made with one swap (A swap exchanges
the positions of two numbers A[i] and A[j]).
 If it cannot be done, then return the same array.

Example 1:
Input: [3,2,1]
Output: [3,1,2]
Explanation: Swapping 2 and 1.

Example 2:
Input: [1,1,5]
Output: [1,1,5]
Explanation: This is already the smallest permutation.

Example 3:
Input: [1,9,4,6,7]
Output: [1,7,4,6,9]
Explanation: Swapping 9 and 7.

Example 4:
Input: [3,1,1,3]
Output: [1,3,1,3]
Explanation: Swapping 1 and 3.*/
class Sln{
    public int[] prevPermOpt1(int[] nums) {
        if (nums.length <= 1) return nums;
        int idx=-1, n=nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]>nums[i+1]){
                idx=i;
            }
        }
        if(idx==-1) return nums;
        for(int i=n-1;i>idx;i--){
            if(nums[i]<nums[idx] && nums[i]!=nums[i-1]){
                int t=nums[i];
                nums[i]=nums[idx];
                nums[idx]=t;
                break;
            }
        }
        return nums;
    }
}