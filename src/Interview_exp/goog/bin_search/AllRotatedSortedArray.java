/*LC33: Search in Rotated Sorted Array
https://leetcode.com/problems/search-in-rotated-sorted-array/
Given an integer array nums sorted in ascending order,
and an integer target.
Suppose that nums is rotated at some pivot unknown to
you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
You should search for target in nums and if you found
return its index, otherwise return -1.
Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:
Input: nums = [1], target = 0
Output: -1
Constraints:
1 <= nums.length <= 5000
-10^4 <= nums[i] <= 10^4
All values of nums are unique.
nums is guranteed to be rotated at some pivot.
-10^4 <= target <= 10^4
Accepted
770,909
Submissions
2,227,711*/
class Sln1 {
    public int search(int[] A, int target) {
        int lo = 0;
        int hi = A.length - 1;
        while (lo < hi) {
            int mid = lo + (hi-lo) / 2;
            if (A[mid] == target) return mid;
            if (A[lo] <= A[mid]) {
                if (target >= A[lo] && target < A[mid]) {
                    hi = mid - 1;
                }
                else {
                    lo = mid + 1;
                }
            }
            else {
                if (target > A[mid] && target <= A[hi]) {
                    lo = mid + 1;
                }
                else {
                    hi = mid - 1;
                }
            }
        }
        return A[lo] == target ? lo : -1;
    }
}
/*LC81: Search in Rotated Sorted Array II
https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
Suppose an array sorted in ascending order
is rotated at some pivot unknown to you beforehand.
(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search.
If found in the array return true, otherwise return false.
Example 1:
Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true

Example 2:
Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
Follow up:
This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
Would this affect the run-time complexity? How and why?*/
class Sln2 {
    public boolean search(int[] nums, int target) {
        if(nums.length==0)
            return false;
        return solv(nums, 0, nums.length-1, target);
    }
    boolean solv(int[] nums, int left, int right, int target) {
        if(right==left)
            return nums[right]==target;
        else if(nums[left]<nums[right]){
            while(left<=right) {
                int middle=left+(left-right)>>1;
                if(nums[middle]==target)
                    return true;
                else if(nums[middle]>target)
                    right=middle-1;
                else
                    left=middle+1;
            }
            return false;
        }
        return solv(nums, left, left+(right-left)>>1, target) | solv(nums, (left+(right-left)>>1)+1, right, target);
    }
}