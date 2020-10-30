/*LC1192: Critical Connections in a Network
* https://leetcode.com/problems/critical-connections-in-a-network/
There are n servers numbered from 0 to n-1
* connected by undirected server-to-server
* connections forming a network where
* connections[i] = [a, b] represents a connection between servers a and b.
* Any server can reach any other server directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some server unable to reach some other server.

Return all critical connections in the network in any order.
Example 1:
Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.*/
class Sln {
    List<List<Integer>> bridges;
    List<Integer>[] graph;
    int[] ids, low;
    int id;
    private void dfs(boolean[] visited, int parent, int i) {
        visited[i] = true;
        ids[i] = low[i] = id++;

        for (int node : graph[i]) {
            if (node == parent) continue;
            if (!visited[node]) {
                dfs(visited, i, node);
                //things below happen during backtracking
                low[i] = Math.min(low[i], low[node]);
                if (ids[i] < low[node])
                    bridges.add(Arrays.asList(i, node));
            }
            else {
                low[i] = Math.min(low[i], ids[node]);
            }
        }
    }
    private void buildGraph(List<List<Integer>> connections) {
        for (int i = 0; i < graph.length; i++)
            graph[i] = new ArrayList<>();
        for (int i = 0; i < connections.size(); i++) {
            int a = connections.get(i).get(0), b = connections.get(i).get(1);
            graph[a].add(b);
            graph[b].add(a);
        }
    }
    public List<List<Integer>> criticalConnections(int n,
                                                   List<List<Integer>> connections) {
        //1. initialize global variables;
        bridges = new ArrayList<>();
        graph = new ArrayList[n];
        ids = new int[n];
        low = new int[n];
        id = 0;

        //2. build graph;
        buildGraph(connections);

        //3. find bridges;
        boolean[] visited = new boolean[n];
        dfs(visited, -1, 0);
        return bridges;
    }
}