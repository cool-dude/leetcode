/*LC1240: Tiling a Rectangle with the Fewest Squares
https://leetcode.com/problems/tiling-a-rectangle-with-the-fewest-squares/
Given a rectangle of size n x m, find the minimum number of integer-sided squares that tile the rectangle.

Example 1:
Input: n = 2, m = 3
Output: 3
Explanation: 3 squares are necessary to cover the rectangle.
2 (squares of 1x1)
1 (square of 2x2)

Example 2:
Input: n = 5, m = 8
Output: 5

Example 3:
Input: n = 11, m = 13
Output: 6*/
class Sln{
    Map<Long,Integer> map=new HashMap<>();
    int res = Integer.MAX_VALUE;
    public int tilingRectangle(int n, int m) {
        if (n == m) return 1;
        if (n > m) return tilingRectangle(m, n);
        dfs(n, m, new int[n], 0);
        return res;
    }
    void dfs(int n,int m,int[] h,int cnt){
        if (cnt >= res) return;
        int pos = -1, minH = Integer.MAX_VALUE;
        long key = 0, base = 1;
        for (int i = 0; i < n; i++) {
            key += h[i] * base;
            base *= m + 1;
            if (h[i] < minH) {
                pos = i;
                minH = h[i];
            }
        }
        if (minH == m) {
            res = Math.min(cnt, res);
            return;
        }
        if (map.containsKey(key) && map.get(key) <= cnt) return;
        map.put(key, cnt);
        int end = pos;
        while (end + 1 < n && h[end + 1] == h[pos] && (end + 1 - pos + 1 + minH) <= m) end++;
        for (int j = end; j >= pos; j--) {
            int[] next = h.clone();
            for (int k = pos; k <= j; k++) next[k] += j - pos + 1;  //mew added squre edge length
            dfs(n, m, next, cnt + 1);
        }
    }
}