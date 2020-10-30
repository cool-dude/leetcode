/*LC1059:All Paths from Source Lead to Destination
https://leetcode.com/problems/all-paths-from-source-lead-to-destination/
Given the edges of a directed graph where edges[i]
= [ai, bi] indicates there is an edge between nodes
ai and bi, and two nodes source and destination
of this graph, determine whether or not all paths
starting from source eventually, end at destination, that is:
At least one path exists from the source node to the destination node
If a path exists from the source node to a node with no outgoing edges, then that node is equal to destination.
The number of possible paths from source to destination is a finite number.
Return true if and only if all roads from source lead to destination.
Example 1:
Input: n = 3, edges = [[0,1],[0,2]], source = 0, destination = 2
Output: false
Explanation: It is possible to reach and get stuck on both node 1 and node 2.

Example 2:
Input: n = 4, edges = [[0,1],[0,3],[1,2],[2,1]], source = 0, destination = 3
Output: false
Explanation: We have two possibilities: to end at node 3, or to loop over node 1 and node 2 indefinitely.

Example 3:
Input: n = 4, edges = [[0,1],[0,2],[1,3],[2,3]], source = 0, destination = 3
Output: true

Example 4:
Input: n = 3, edges = [[0,1],[1,1],[1,2]], source = 0, destination = 2
Output: false
Explanation: All paths from the source node end at the destination node,
but there are an infinite number of paths, such as 0-1-2, 0-1-1-2, 0-1-1-1-2, 0-1-1-1-1-2, and so on.*/
class Sln{
    enum State { PROCESSING, PROCESSED }
    boolean leadsToDest(List<Integer>[] g,int node,int dst,State[] states){
        if(states[node]!=null) return states[node]==State.PROCESSED;
        if(g[node].isEmpty()) return node==dst;
        states[node]==State.PROCESSING;
        for(int nbr:g[node])
            if(!leadsToDest(g,nbr,dst,states)) return false;
        states[node]=State.PROCESSED;
        return true;
    }
    List<Integer>[] buildDigraph(int n,int[][] edges){
        List<Integer>[] gr=new List[n];
        for(int i=0;i<n;i++)
            gr[i]=new ArrayList<>();
        for(int[] e:edges)
            gr[e[0]].add(e[1]);
        return gr;
    }
    public boolean leadsToDestination(int n, int[][] edges, int src, int dst) {
        List<Integer>[] gr=buildDigraph(n,edges);
        return leadsToDest(gr,src,dst,new State[n]);
    }
}