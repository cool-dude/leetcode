/*LC684: Redundant Connection
https://leetcode.com/problems/redundant-connection/
In this problem, a tree is an undirected
graph that is connected and has no cycles.
The given input is a graph that started as a
tree with N nodes (with distinct values 1, 2, ..., N),
with one additional edge added. The added
edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array
of edges. Each element of edges is a pair [u, v]
with u < v, that represents an undirected edge connecting nodes u and v.

Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.
Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given undirected graph will be like this:
1
/ \
2 - 3
Example 2:
Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
Output: [1,4]
Explanation: The given undirected graph will be like this:
5 - 1 - 2
|   |
4 - 3*/
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parents = new int[2001];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            if(find(from, parents) == find(to, parents)) {
                return edge;
            }
            union(from, to, parents);
        }
        return null;
    }
    int find(int node, int[] parents) {
        while(node != parents[node]) {
            node = parents[node];
        }
        return node;
    }
    void union(int a, int b, int[] parents) {
        int aRoot = find(a, parents);
        int bRoot = find(b, parents);
        if(aRoot == bRoot) return;
        parents[aRoot] = bRoot;
    }
}