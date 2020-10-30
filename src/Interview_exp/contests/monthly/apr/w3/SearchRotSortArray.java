/*LC33: Search in Rotated Sorted Array
Suppose an array sorted in ascending order
is rotated at some pivot unknown to you beforehand.
(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3*/
class Sln {
    int helper(int[] nums,int lo,int hi, int key){
        if(lo>hi)
            return -1;
        int mi=lo+(hi-lo)/2;
        if(nums[mi]==key){
            return mi;
        }
        //1ist part sorted
        if(nums[lo]<=nums[mi]){
            if(key>=nums[lo] && key<nums[mi]){
                return helper(nums,lo,mi-1,key);
            }
            else {
                return helper(nums,mi+1,hi, key);
            }
        }
        //2nd part sorted
        if(nums[mi]<=nums[hi]){
            if(key>nums[mi] && key<=nums[hi]){
                return helper(nums,mi+1,hi, key);
            }
            else{
                return helper(nums,0,mi-1,key);
            }
        }
        return -1;
    }
    public int search(int[] nums,int target){
        return helper(nums,0,nums.length-1,target);
    }
}