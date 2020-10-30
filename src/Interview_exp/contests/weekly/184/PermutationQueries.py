'''
Let's use a map vimap from values to index positions.
Initially, all the values will start at positions [n+1, ..., 2n];
every time we pop a value, it will be placed again at positions n, n-1, n-2, etc.

We also use a fenwick tree. This data structure is kind
of like a virtual array A that lets us do two things in
 O(n log n) time: .add(i, x) is like A[i] += x, and .sum(i) is like sum(A[:i+1]).

Now for every query value, we can use the fenwick tree to find the rank of that query value.'''
class Fenwick:
    def __init__(self, n):
        sz = 1
        while sz <= n:
            sz *= 2
        self.size = sz
        self.data = [0] * sz
    def sum(self, i):
        s = 0
        while i > 0:
            s += self.data[i]
            i -= i & -i
        return s
    def add(self, i, x):
        while i < self.size:
            self.data[i] += x
            i += i & -i

class Solution2(object):
    def processQueries(self, queries, n):
        fenw = Fenwick(2 * n)
        vimap = {}
        for i in range(1, n + 1):
            fenw.add(i + n, 1)
            vimap[i] = i + n
        cur = n
        ans = []
        for q in queries:
            i = vimap.pop(q)
            rank = fenw.sum(i-1)
            ans.append(rank)

            vimap[q] = cur
            fenw.add(i, -1)
            fenw.add(cur, 1)
            cur -= 1
        return ans