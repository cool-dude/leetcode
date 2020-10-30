/*LC1425: Constrained Subset Sum
https://leetcode.com/problems/constrained-subset-sum/
Given an integer array nums and an integer k,
return the maximum sum of a non-empty subset
of that array such that for every two consecutive
integers in the subset, nums[i] and nums[j],
where i < j, the condition j - i <= k is satisfied.

Example 1:
Input: nums = [10,2,-10,5,20], k = 2
Output: 37
Explanation: The subset is [10, 2, 5, 20].

Example 2:
Input: nums = [-1,-2,-3], k = 1
Output: -1
Explanation: The subset must be non-empty, so we choose the largest number.

Example 3:
Input: nums = [10,-2,-10,-5,20], k = 2
Output: 23
Explanation: The subset is [10, -2, -5, 20].*/
/*SLN:
Intuition
We need to know the maximum in the window of size k.
Use heap will be O(NlogK)
Use deque will be O(N)
Done. (If not done, continue read)

Prepare
How about google "sliding window maximum",
and make sure you understand 239. Sliding Window Maximum
Done. (If not done, continue read)

Explanation
Update res[i],
where res[i] means the maximum result you can get if the last element is A[i].

I directly modify on the input A,
if you don't like it,
use a copy of A

Keep a decreasing deque q,
deque[0] is the maximum result
in the last element of result.

If deque[0] > 0. we add it to A[i]

In the end, we return the maximum res.
Complexity
Time O(N)
Space O(K)*/
class Sln{
    public int constrainedSubsetSum(int[] A, int k) {
        int res = A[0];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < A.length; ++i) {
            A[i] += !q.isEmpty() ? q.peek() : 0;
            res = Math.max(res, A[i]);
            while (!q.isEmpty() && A[i] > q.peekLast())
                q.pollLast();
            if (A[i] > 0)
                q.offer(A[i]);
            if (i >= k && !q.isEmpty() && q.peek() == A[i - k])
                q.poll();
        }
        return res;
    }
}