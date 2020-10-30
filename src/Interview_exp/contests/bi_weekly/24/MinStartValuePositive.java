/*LC1413: Minimum Value to Get Positive Step by Step Sum
Given an array of integers nums, you start
with an initial positive value startValue.
In each iteration, you calculate the step by
step sum of startValue plus elements in nums (from left to right).
Return the minimum positive value of startValue
such that the step by step sum is never less than 1.

Example 1:
Input: nums = [-3,2,-3,4,2]
Output: 5
Explanation: If you choose startValue = 4,
in the third iteration your step by step sum is less than 1.

Example 2:
Input: nums = [1,2]
Output: 1
Explanation: Minimum start value should be positive.

Example 3:
Input: nums = [1,-2,-3]
Output: 5*/
class Sln {
    public int minStartValue(int[] nums) {
        int min_so_far = 0;
        int min_elem = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min_so_far+=nums[i];
            min_elem = Math.min(min_elem, min_so_far);
        }
        if(min_elem<=0){
            return 1-min_elem;
        }
        else
            return 1;
    }
}