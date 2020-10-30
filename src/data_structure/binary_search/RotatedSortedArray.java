/*LC81. Search in Rotated Sorted Array II
Suppose an array sorted in ascending order is
* rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found
* in the array return true, otherwise return false.

Example 1:
Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
Follow up:
This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
Would this affect the run-time complexity? How and why?*/
class Sln{
    boolean solv(int[] nums, int l,int r,int key){
        if(l==r){
            return nums[r]==key;
        }
        else if(nums[l]<nums[r]){
            int mi=l+(r-l)/2;
            if(nums[mi]==key){
                return true;
            }
            else if(nums[mi]>key){
                r=mi-1;
            }
            else {
                l=mi+1;
            }
        }
        return false;
    }
    public boolean search(int[] nums, int target) {
        if(nums.length==0)
            return false;
        return solv(nums, 0, nums.length-1, target);
    }
}