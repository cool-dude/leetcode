'''LC1439: Find the Kth Smallest Sum of a Matrix With Sorted Rows
https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/
You are given an m * n matrix, mat,
and an integer k, which has its rows
sorted in non-decreasing order.
You are allowed to choose exactly 1
element from each row to form an array. Return the Kth smallest array sum among all possible arrays.

Example 1:
Input: mat = [[1,3,11],[2,4,6]], k = 5
Output: 7
Explanation: Choosing one element from each row, the first k smallest sum are:
[1,2], [1,4], [3,2], [3,4], [1,6]. Where the 5th sum is 7.

Example 2:
Input: mat = [[1,3,11],[2,4,6]], k = 9
Output: 17

Example 3:
Input: mat = [[1,10,10],[1,4,5],[2,3,6]], k = 7
Output: 9
Explanation: Choosing one element from each row, the first k smallest sum are:
[1,1,2], [1,1,3], [1,4,2], [1,4,3], [1,1,6], [1,5,2], [1,5,3]. Where the 7th sum is 9.

Example 4:
Input: mat = [[1,1,10],[2,2,9]], k = 7
Output: 12'''
class Solution1:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int = 200) -> List[List[int]]:
        res = []
        h = []
        if len(nums1) == 0 or len(nums2) == 0 or k == 0:
            return res
        i = 0
        while i < len(nums1) and i < k:
            heapq.heappush(h, (nums1[i]+nums2[0], nums1[i], nums2[0], 0))
            i += 1
        while k and h:
            cur = heappop(h)
            res.append(cur[0])
            if cur[3] == len(nums2) - 1:
                continue
            heapq.heappush(h, (cur[1]+nums2[cur[3]+1], cur[1], nums2[cur[3]+1], cur[3]+1))
            k -= 1
        return res
    def kthSmallest(self, mat: List[List[int]], k: int) -> int:
        m, n = len(mat), len(mat[0])
        res = mat[0]
        for i in range(1, m):
            res = self.kSmallestPairs(res, mat[i])
        return res[k-1]

class Solution2:
    def kthSmallest(self, mat: List[List[int]], k: int) -> int:
        h = mat[0][:]
        for row in mat[1:]:
            h = sorted([i+j for i in row for j in h])[:k]
        return h[k-1]