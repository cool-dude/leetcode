/*LC16:3Sum Closest
https://leetcode.com/problems/3sum-closest
Given an array nums of n integers and an integer target,
* find 3 integers in nums such that the sum is closest
* to target. Return the sum of the three integers.
* You may assume that each input would have exactly one solution.

Example:
Given array nums = [-1, 2, 1, -4], and target = 1.
The sum that is closest to the target is 2.
* (-1 + 2 + 1 = 2).*/
class Sln {
    public int 3SumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length-2;i++) {
            int left = i+1;
            int right = nums.length-1;
            while(left < right) {
                int tempSum = nums[i]+nums[left]+nums[right];
                int tempDiff = Math.abs(tempSum-target);
                if(tempDiff < diff) {
                    sum = tempSum;
                    diff = tempDiff;
                }
                if(tempSum > target) right--;
                else if(tempSum < target) left++;
                else {
                    return target;
                }
            }
        }
        return sum;
    }
    //T:O(N^2).
    //S:O(1).
}