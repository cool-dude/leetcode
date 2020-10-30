import math
class Solution:
    def minSubArrayLen(self, s, nums):
        out = math.inf
        add = 0
        start = 0

        for i, num in enumerate(nums):
           add += num
           while add >= s:
              add -= nums[start]
              out = min(out, i+1-start)
              start += 1

        return out if out != math.inf else -1