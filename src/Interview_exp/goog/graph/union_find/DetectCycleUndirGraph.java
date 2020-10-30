/*Let us consider the following graph:
cycle-in-graph
For each edge, make subsets using both the
vertices of the edge. If both the vertices are
in the same subset, a cycle is found.

Initially, all slots of parent array are initialized
to -1 (means there is only one item in every subset).
0   1   2
-1 -1  -1
Now process all edges one by one.

Edge 0-1: Find the subsets in which vertices 0 and 1 are.
Since they are in different subsets, we take the union of them.
For taking the union, either make node 0 as parent of node 1 or vice-versa.

0   1   2    <----- 1 is made parent of 0 (1 is now representative of subset {0, 1})
1  -1  -1
Edge 1-2: 1 is in subset 1 and 2 is in subset 2. So, take union.

0   1   2    <----- 2 is made parent of 1 (2 is now representative of subset {0, 1, 2})
1   2  -1
Edge 0-2: 0 is in subset 2 and 2 is also in subset 2. Hence, including this edge forms a cycle.

How subset of 0 is same as 2?
0->1->2 // 1 is parent of 0 and 2 is parent of 1*/
// Java Program for union-find algorithm to detect cycle in a graph
import java.util.*;
import java.lang.*;
import java.io.*;
class Graph {
    int V, E; // V-> no. of vertices & E->no.of edges
    Edge edge[]; // /collection of all edges
    class Edge {
        int src, dest;
    };
    Graph(int v,int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i=0; i<e; ++i)
            edge[i] = new Edge();
    }
    int find(int parent[], int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }
    void Union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }
    boolean isCycle() {
        int parent[] = new int[this.V];
        for (int i=0; i<this.V; ++i)
            parent[i]=-1;
        for (int i = 0; i < this.E; ++i) {
            int x = find(parent, this.edge[i].src);
            int y = find(parent, this.edge[i].dest)
            if (x == y)
                return true;
            graph.Union(parent, x, y);
        }
        return false;
    }
    public static void main (String[] args) {
		/* Let us create following graph
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

        if (graph.isCycle())
            System.out.println( "graph contains cycle" );
        else
            System.out.println( "graph doesn't contain cycle" );
    }
    //T:O(n) worst case(skewed tree).
}