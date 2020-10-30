import java.io.*;
import java.util.*;
class Graph{
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists
    Graph(int v_){
        V = v_;
        adj = new LinkedList[V];
        for (int i=0; i<V; ++i)
            adj[i] = new LinkedList();
    }
    void addEdge(int v_,int w_){
        adj[v_].add(w_);
    }
    void BFS(int src){
        boolean[] visited=new boolean[V];
        Queue<Integer> queue=new LinkedList<Integer>();
        visited[src]=true;
        queue.add(src);
        while (!queue.isEmpty()){
            src=queue.poll();
            Iterator<Integer> it=adj[src].iterator();
            while (it.hasNext()){
                int nbr=it.next();
                if(!visited[nbr]){
                    visited[nbr]=true;
                    queue.add(nbr);
                }
            }
        }
    }
    // Driver method to
    public static void main(String args[]){
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");
        g.BFS(2);
    }
}