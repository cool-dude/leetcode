/*
LC75: Sort Colors
Given an array with n objects colored red,
white or blue, sort them in-place so that
objects of the same color are adjacent,
with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2
to represent the color red, white, and blue respectively.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?*/
class Sln{
    private void swap(int[] nums, int lo, int hi){
        if(lo!=hi) {
            int t = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = t;
        }
    }
    public void sortColors(int[] nums){
        int lo =0;
        int mi = 0;
        int hi = arr.length - 1;
        // one pass through the array swapping
        // the necessary elements in place
        while (mi <= hi) {
            if (nums[mi] == 0) { swap(nums, lo++, mi++); }
            else if (arr[mi] == 2) { swap(nums, mi, hi--); }
            else if (arr[mi] == 1) { mi++; }
        }
        return arr;
    }
}