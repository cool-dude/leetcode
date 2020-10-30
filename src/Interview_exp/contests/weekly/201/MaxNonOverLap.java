/*LC1546. Maximum Number of Non-Overlapping
Subarrays With Sum Equals Target
https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/
Given an array nums and an integer target.

Return the maximum number of non-empty non-overlapping
subarrays such that the sum of values in each subarray is equal to target.

Example 1:
Input: nums = [1,1,1,1,1], target = 2
Output: 2
Explanation: There are 2 non-overlapping subarrays [1,1,1,1,1] with sum equals to target(2).

Example 2:
Input: nums = [-1,3,5,1,4,2,-9], target = 6
Output: 2
Explanation: There are 3 subarrays with sum equal to 6.
([5,1], [4,2], [3,5,1,4,2,-9]) but only the first 2 are non-overlapping.

Example 3:
Input: nums = [-2,6,6,3,5,4,1,2,8], target = 10
Output: 3

Example 4:
Input: nums = [0,0,0], target = 0
Output: 3*/
class Sln {
    public int maxNonOverlapping(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int res = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (map.containsKey(sum - target)) {
                res = Math.max(res, map.get(sum - target) + 1);
            }
            map.put(sum, res);
        }
        return res;
    }
}