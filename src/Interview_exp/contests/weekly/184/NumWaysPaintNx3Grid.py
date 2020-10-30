class Solution(object):
    def numOfWays(self, n):
        """
        :type n: int
        :rtype: int
        """
        a121, a123, mod = 6, 6, 10**9 + 7
        for i in xrange(n - 1):
            a121, a123 = a121 * 3 + a123 * 2, a121 * 2 + a123 * 2
        return (a121 + a123) % mod
