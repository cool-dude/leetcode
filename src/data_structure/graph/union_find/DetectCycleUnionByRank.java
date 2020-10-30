/*The above operations can be optimized to O(Log n)
in worst case. The idea is to always attach smaller
depth tree under the root of the deeper tree. This
technique is called union by rank. The term rank is
preferred instead of height because if path compression
technique (we have discussed it below) is used, then
rank is not always equal to height. Also, size (in place of height)
of trees can also be used as rank. Using size as rank also yields
worst case time complexity as O(Logn) (See this for proof)Let us see the above example with union by rank
Initially, all elements are single element subsets.
0 1 2 3

Do Union(0, 1)
   1   2   3
  /
 0

Do Union(1, 2)
   1    3
 /  \
0    2

Do Union(2, 3)
    1
 /  |  \
0   2   3*/
// A union by rank and path compression
// based program to detect cycle in a graph
package data_structure.graph.union_find;
import java.util.*;
import java.lang.*;
import java.io.*;
class Graph {
    int V, E;
    Edge[] edge;
    Graph(int nV, int nE) {
        V = nV;
        E = nE;
        edge = new Edge[E];
        for (int i = 0; i < E; i++)
            edge[i] = new Edge();
    }
    class Edge {
        int src, dst;
    }
    class subset {
        int parent;
        int rank;
    }
    int find(subset[] subsets, int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }
    void union(subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[yroot].rank < subsets[xroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[xroot].parent = yroot;
            subsets[yroot].rank++;
        }
    }
    boolean isCycle(Graph graph) {
        int V = graph.V;
        int E = graph.E;
        subset[] subsets = new subset[V];
        for (int v = 0; v < V; v++) {
            subsets[v] = new subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        for (int e = 0; e < E; e++) {
            int x = find(subsets, graph.edge[e].src);
            int y = find(subsets, graph.edge[e].dest);
            if(x == y)
                return true;
            union(subsets, x, y);
        }
        return 0;
    }
    // Driver Code
    public static void main(String [] args) {
        /* Let us create the following graph
	    0
	    | \
	    | \
	    1-----2 */
        int V = 3, E = 3;
        Graph graph = new Graph(V, E);
        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;
        // add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;
        if (graph.isCycle(graph) == 1)
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
    }
}