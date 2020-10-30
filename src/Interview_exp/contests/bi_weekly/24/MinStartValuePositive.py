'''
LC1413: Minimum Value to Get Positive Step by Step Sum
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
Output: 5
Process1:
Simulate starting at 0, and let's say
the minimum value you attain during the
process is m.  If say, m = -4, then you
should choose the starting value start = 5,
because it would just shift all the intermediate
values up by 5.  While if m = 100, then we just
 choose the minimum possible starting value start = 1.
In general, the answer is max(1, 1 - m).'''
class Solution(object):
    def minStartValue(self, nums):
        prefix = [0]
        for x in nums:
            prefix.append(prefix[-1] + x)
        return max(1, 1 - min(prefix))