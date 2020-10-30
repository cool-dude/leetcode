/*LC1377: Frog Position After T Seconds
https://leetcode.com/problems/frog-position-after-t-seconds/
Given an undirected tree consisting of
n vertices numbered from 1 to n. A frog
starts jumping from the vertex 1. In one
second, the frog jumps from its current
vertex to another unvisited vertex if
they are directly connected. The frog
can not jump back to a visited vertex.
In case the frog can jump to several vertices
it jumps randomly to one of them with
the same probability, otherwise, when the
frog can not jump to any unvisited vertex
it jumps forever on the same vertex.

The edges of the undirected tree are given
in the array edges, where edges[i] = [fromi, toi]
means that exists an edge connecting directly the vertices fromi and toi.

Return the probability that after t seconds the frog is on the vertex target.

Example 1:
Input: n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 2, target = 4
Output: 0.16666666666666666
Explanation: The figure above shows the given graph. The frog
starts at vertex 1, jumping with 1/3 probability to the
vertex 2 after second 1 and then jumping with 1/2 probability
to vertex 4 after second 2. Thus the probability for the
frog is on the vertex 4 after 2 seconds is 1/3 * 1/2 = 1/6 = 0.16666666666666666.

Example 2:
Input: n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 1, target = 7
Output: 0.3333333333333333
Explanation: The figure above shows the given graph. The frog starts at vertex 1, jumping with 1/3 = 0.3333333333333333 probability to the vertex 7 after second 1.
Example 3:

Input: n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 20, target = 6
Output: 0.16666666666666666*/
class Sln{
    public double frogPosition(int n,int[][] edges,int t,int target){
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0] - 1].add(e[1] - 1);
            graph[e[1] - 1].add(e[0] - 1);
        }
        boolean[] visited = new boolean[n]; visited[0] = true;
        double[] prob = new double[n]; prob[0] = 1f;
        Queue<Integer> q = new LinkedList<>(); q.offer(0);
        while (!q.isEmpty() && t-- > 0) {
            for (int size = q.size(); size > 0; size--) {
                int u = q.poll(), nextVerticesCount=u==0?graph[u].size():graph[u].size()-1;
                for (int v : graph[u]) {
                    if (!visited[v]) {
                        visited[v] = true;
                        q.offer(v);
                        prob[v] = prob[u] / nextVerticesCount;
                    }
                }
                if (nextVerticesCount > 0) prob[u] = 0; // frog don't stay vertex u, he keeps going to the next vertex
            }
        }
        return prob[target - 1];
    }
    //T:O(n)
    //S:O(n)
}