/*
* LC153: Find Minimum in Rotated Sorted Array
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
* Suppose an array sorted in ascending order
* is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2]
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0*/
class Sln{
    public int findMin(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int left=0,right=nums.length-1;
        //if right elm>0 elm...array not rotated
        //1st element min
        if(nums[right]>nums[0]){
            return nums[0];
        }
        while (right>=left){
            int mid=left+(right-left)/2;
            //if mid is greater than next
            //it is pivot
            if(nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            if(nums[mid-1]>nums[mid]){
                return nums[mid];
            }
            //mid is greater than 0
            //1st part sorted
            if(nums[mid]>nums[0]){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return -1;
    }
}