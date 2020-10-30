/*LC1: Two Sum
https://leetcode.com/problems/two-sum/
Given an array of integers, return indices
of the two numbers such that they add up to a specific target.

You may assume that each input would
have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1]*/
class Sln1 {
    public static int[] twoSum(int[] nums, int target) {
        // int difference = target - nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= nums.length - 1; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else
                map.put(nums[i], i);
        }
        return new int[]{};
    }
}
/*LC167: Two Sum II - Input array is sorted
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
Given an array of integers that is already
sorted in ascending order, find two numbers
such that they add up to a specific target number.

The function twoSum should return indices of the two
numbers such that they add up to the target,
where index1 must be less than index2.

Note:
Your returned answers (both index1 and index2)
are not zero-based.
You may assume that each input would have exactly
one solution and you may not use the same element twice.

Example:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9.
Therefore index1 = 1, index2 = 2.*/
class Sln2 {
    public int[] twoSum(int[] numbers, int target) {
        int n=numbers.length;
        int l=0,r=n-1;
        while (l<=r){
            if(numbers[l]+numbers[r]<target) {
                l++;
            }
            else if(numbers[l]+numbers[r]>target){
                r--;
            }
            else {
                return new int[]{l,r};
            }
        }
        return new int[]{-1,-1};
    }
}