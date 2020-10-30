/*
LC1409: Queries on a Permutation With Key
Given the array queries of positive integers
between 1 and m, you have to process all queries[i] (
from i=0 to i=queries.length-1) according to the following rules:
In the beginning, you have the permutation P=[1,2,3,...,m].
For the current i, find the position of queries[i] in the permutation P
(indexing from 0) and then move this at the beginning of the permutation P.
 Notice that the position of queries[i] in P is the result for queries[i].
 eturn an array containing the result for the given queries.


Example 1:
Input: queries = [3,1,2,1], m = 5
Output: [2,1,2,1]
Explanation: The queries are processed as follow:
For i=0: queries[i]=3, P=[1,2,3,4,5], position of 3 in P is 2, then we move 3 to the beginning of P resulting in P=[3,1,2,4,5].
For i=1: queries[i]=1, P=[3,1,2,4,5], position of 1 in P is 1, then we move 1 to the beginning of P resulting in P=[1,3,2,4,5].
For i=2: queries[i]=2, P=[1,3,2,4,5], position of 2 in P is 2, then we move 2 to the beginning of P resulting in P=[2,1,3,4,5].
For i=3: queries[i]=1, P=[2,1,3,4,5], position of 1 in P is 1, then we move 1 to the beginning of P resulting in P=[1,2,3,4,5].
Therefore, the array containing the result is [2,1,2,1]. */
/*create a fenwick array with length m + n + 1, where m is the number range, n is the length of queries
        initially, locate number [1,m] at position [n+1, n+m] with value 1
        for each query, relocate queries[i] to a position [1,n] in reverse order
        queries[0] is relocated to position n, queries[1] is relocated to position n - 1, ..., queries[n] is relocated to position 1
        prefix sum of queries[i] tells us how many numbers are before queries[i]*/
class Sln {
    class BIT {
        int[] a;
        public BIT(int n) {
            a = new int[n];
        }
        public void add(int index, int delta) {
            index++;
            while (index < a.length) {
                a[index] += delta;
                index += index & (-index);
            }
        }
        public int prefixSum(int index) {
            index++;
            int res = 0;
            while (index > 0) {
                res += a[index];
                index -= index & (-index);
            }
            return res;
        }
    }
    public int[] processQueries(int[] queries, int m) {
        int n = queries.length;
        BIT bit = new BIT(n+m+1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            bit.add(n+i, 1);
            map.put(i, n+i);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int index = map.remove(queries[i]);
            res[i] = bit.prefixSum(index-1);

            int new_index = n - i;
            bit.add(index, -1);
            bit.add(new_index, 1);
            map.put(queries[i], new_index);
        }
        return res;
    }
}