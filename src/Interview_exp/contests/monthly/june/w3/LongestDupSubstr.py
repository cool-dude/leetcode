'''
Intuition:
Suffix array is typical solution for this problem.
The fastest way is to copy a template form the Internet.
The code will be quite long.
Here I want to share a binary search solution.

Explanation:
Binary search the length of longest duplicate substring and call the help function test(L).
test(L) slide a window of length L,
rolling hash the string in this window,
record the seen string in a hashset,
and try to find duplicated string.

I give it a big mod for rolling hash and it should be enough for this problem.
Actually there could be hash collision.
One solution is to have two different mod for hash.
Or we can use a hashmap to record the index of string.

Complexity:
Binary Search in range 1 and N, so it's O(logN)
Rolling hash O(N)
Overall O(NlogN)
SpaceO(N)
'''
class Solution(object):
    def longestDupSubstring(self, S):
        """
        :type S: str
        :rtype: str
        """
        A = [ord(c) - ord('a') for c in S]
        mod = 2**63 - 1
        def test(L):
            p = pow(26, L, mod)
            cur = reduce(lambda x, y: (x * 26 + y) % mod, A[:L], 0)
            seen = {cur}
            for i in xrange(L, len(S)):
                cur = (cur * 26 + A[i] - A[i - L] * p) % mod
                if cur in seen: return i - L + 1
                seen.add(cur)
        res, lo, hi = 0, 0, len(S)
        while lo < hi:
            mi = (lo + hi + 1) / 2
            pos = test(mi)
            if pos:
                lo = mi
                res = pos
            else:
                hi = mi - 1
        return S[res:res + lo]