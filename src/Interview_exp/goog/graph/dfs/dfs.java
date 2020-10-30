import java.io.*;
import java.util.*;
class Graph{
    private int V;
    // No. of vertices
    private LinkedList<Integer> adj[];
    Graph(int v){
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
    void addEdge(int v, int w) {
        adj[v].add(w);
    }
    void DFSUtil(int src, boolean[] visited){
        visited[v]=true;
        Iterator<Integer> it=adj[v].listIterator();
        while (it.hasNext()){
            int nbr=it.next();
            if(!visited[nbr])
                DFSUtil(nbr, visited);
        }
    }
    void DFS(int v){
        boolean[] visited=new boolean[V];
        DFSUtil(v, visited);
    }
    public static void main(String args[]){
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");
        g.DFS(2);
    }
}