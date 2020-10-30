/*LC1632: Rank Transform of a Matrix
https://leetcode.com/problems/rank-transform-of-a-matrix/
Given an m x n matrix, return a new
matrix answer where answer[row][col] is the rank of matrix[row][col].
The rank is an integer that represents how large an element is compared to other elements. It is calculated using the following rules:
If an element is the smallest element in its row and column, then its rank is 1.
If two elements p and q are in the same row or column, then:
If p < q then rank(p) < rank(q)
If p == q then rank(p) == rank(q)
If p > q then rank(p) > rank(q)
The rank should be as small as possible.
It is guaranteed that answer is unique under the given rules.
Example 1:
Input: matrix = [[1,2],[3,4]]
Output: [[1,2],[2,3]]

Example 2:
Input: matrix = [[7,7],[7,7]]
Output: [[1,1],[1,1]]

Example 3:
Input: matrix = [[20,-21,14],[-19,4,19],[22,-47,24],[-19,4,19]]
Output: [[4,2,3],[1,3,4],[5,1,6],[1,3,4]]

Example 4:
Input: matrix = [[7,3,6],[1,4,5],[9,8,2]]
Output: [[5,1,4],[1,2,3],[6,3,1]]
Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 500
-109 <= matrix[row][col] <= 109*/
class UF {
    int[] parent;
    public UF(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    public int find(int x) {
        return parent[x] = parent[x] == x ? x : find(parent[x]);
    }
    public Pair<Integer, Integer> union(int x, int y) {
        int px = find(x);
        int py = find(y);
        parent[px] = py;
        return new Pair<>(px, py);
    }
}
class Sln {
    public int[][] matrixRankTransform(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] rank = new int[n + m];
        Map<Integer, List<Pair<Integer, Integer>>> invMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                invMap.computeIfAbsent(matrix[i][j], l -> new ArrayList<>()).add(new Pair<>(i, j));
            }
        }
        List<Integer> keySet = new ArrayList<>(invMap.keySet());
        Collections.sort(keySet);
        for (int key : keySet) {
            UF uf = new UF(n + m);
            int[] rank2 = rank.clone();
            for (Pair<Integer, Integer> coord : invMap.get(key)) {
                Pair<Integer, Integer> res = uf.union(coord.getKey(), coord.getValue() + n);
                rank2[res.getValue()] = Math.max(rank2[res.getValue()], rank2[res.getKey()]);
            }
            for (Pair<Integer, Integer> coord : invMap.get(key)) {
                rank[coord.getKey()] = rank[coord.getValue() + n] = matrix[coord.getKey()][coord.getValue()] = rank2[uf.find(coord.getKey())] + 1;
            }
        }
        return matrix;
    }
}