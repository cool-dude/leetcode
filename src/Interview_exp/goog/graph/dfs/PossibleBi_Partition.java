package data_structure.graph.dfs;
/*LC886: Possible Bipartition
https://leetcode.com/problems/possible-bipartition/
Given a set of N people (numbered 1, 2, ..., N),
we would like to split everyone into two groups of any size.
Each person may dislike some other people,
 and they should not go into the same group.
Formally, if dislikes[i] = [a, b], it
means it is not allowed to put the people numbered a and b into the same group.
Return true if and only if it is
possible to split everyone into two groups in this way.
Example 1:
Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]
Example 2:
Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false

Example 3:
Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false */
import java.util.*;
class Sln {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    //0-> node is not colored
    //1 -> colored in group 1
    //-1-> colored in group 2
    public boolean possibleBipartition(int N, int[][] dislikes) {
        buildGraph(graph, N, dislikes);
        int[] colors = new int[N+1];
        for (int node = 1; node <= N; node++) {
            if (colors[node] == 0 && !dfs(graph, node, 1, colors))
                return false;
        }
        return true;
    }
    boolean dfs(Map<Integer, List<Integer>> graph, int node, int color, int[] colors) {
        if (colors[node] != 0) {
            //conflict case
            if (colors[node] == color) return true;
            else return false;
        }
        //color the node
        colors[node] = color;
        // no child/ person does not dislike anyone
        if (graph.get(node) == null) return true;
        for (int p : graph.get(node)) {
            // if there is any conflict in the down stream it has to return false
            if (!dfs(graph, p, -color, colors)) return false;
        }
        return true;
    }
    void buildGraph(Map<Integer, List<Integer>> graph, int n, int[][] dislikes) {
        for (int[] dislike : dislikes) {
            int x = dislike[0];
            int y = dislike[1];
            graph.compute(x, (k, v) -> v == null ? new ArrayList<>() : v).add(y);
            graph.compute(y, (k, v) -> v == null ? new ArrayList<>() : v).add(x);
        }
    }
}