import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//DFS, if DFS stack
//already has element,
//then cyclic
class Graph {
    private final int V;
    private final List<List<Integer>> adj;
    public Graph(int v_) {
        this.V = v_;
        adj = new int[V];
        for (int i = 0; i < V; i++)
            adj.add(new LinkedList<>());
    }
    private void addEdge(int s,int d){
        adj.get(s).add(w)
    }
    private boolean helper(int src, boolean[] visited, int parent){
        visited[src]=true;
        List<Integer> nodes=adj.get(src);
        for(Integer nbr:nodes){
            if(!visited[nbr])
                if(isCyclicUtil(nbr,vis,src)
                    return true;
            else if(nbr!=parent)
                return true
        }
        return false;
    }
    private boolean isCyclic(){
        boolean[] visited=new boolean[V];
        Arrays.fill(visited, false);
        for(int i=0;i<V;i++)
            if(!visited[i])
                if(helper(i,visited,-1));
                    return true;
        return false;
    }
}