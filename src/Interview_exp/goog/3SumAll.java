/*LC15: 3Sum
https://leetcode.com/problems/3sum/
Given an array nums of n integers, are there
elements a, b, c in nums such that a + b + c = 0?
Find all unique triplets in the array which gives
the sum of zero.

Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:
Input: nums = []
Output: []

Example 3:
Input: nums = [0]
Output: []
Constraints:
0 <= nums.length <= 3000
-105 <= nums[i] <= 105*/
class Sln {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (j < k) {
                if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }
                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                }
                else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                }
                else {
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    result.add(l);
                    j++;
                    k--;
                }
            }
        }
        return result;
    }
}
/*LC16: 3Sum Closest
https://leetcode.com/problems/3sum-closest/
Given an array nums of n integers and an
integer target, find three integers in nums
such that the sum is closest to target. Return
the sum of the three integers. You may assume
that each input would have exactly one solution.

Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Constraints:

3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4*/
class Sln2 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length-2;i++) {
            int left = i+1;
            int right = nums.length-1;
            while(left < right) {
                int tempSum = nums[i]+nums[left] + nums[right];
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
}