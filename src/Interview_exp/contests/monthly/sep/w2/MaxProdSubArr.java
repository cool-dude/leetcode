/*LC152: Maximum Product Subarray
https://leetcode.com/problems/maximum-product-subarray/
Given an integer array nums, find the
contiguous subarray within an array
(containing at least one number)
which has the largest product.

Example 1:
Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.*/
class Sln {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int t = Math.max(curr, Math.max(max_so_far * curr, min_so_far * curr));
            min_so_far = Math.min(curr, Math.min(max_so_far * curr, min_so_far * curr));
            max_so_far = t;
            result = Math.max(max_so_far, result);
        }
        return result;
    }
}