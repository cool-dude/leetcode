'''LC1167. Minimum Cost to Connect Sticks
* https://leetcode.com/problems/minimum-cost-to-connect-sticks/
You have some sticks with positive integer lengths.

You can connect any two sticks of lengths X and Y into
* one stick by paying a cost of X + Y.  You perform this
* action until there is one stick remaining.

Return the minimum cost of connecting all the given
* sticks into one stick in this way.

Example 1:
Input: sticks = [2,4,3]
Output: 14
*
Example 2:
Input: sticks = [1,8,3,5]
Output: 30'''
from heapq import heappop, heappush, heapify
def minCost(ropes: List[int]) -> int:
    if not ropes: return 0
    if len(ropes) == 1: return ropes[0]
    heapify(ropes)
    cost = 0
    while len(ropes) > 1:
        a, b = heappop(ropes), heappop(ropes)
        cost += a+b
        if ropes:
            heappush(ropes, a+b)
    return cost