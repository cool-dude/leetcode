import java.util.ArrayList;
import java.util.List;
public class AllPaths {
    static boolean[] visited;
    static List<List<Integer>> result;
    static List<Integer> localList;
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        visited = new boolean[4];
        result = new ArrayList<>();
        localList = new ArrayList<>();
        findAllPathsFromSourceTarget(g, 2, 3);
    }
    public void findAllPathsFromSourceTarget(Graph g, int src,int tgt){
        if(src==tgt){
            result.add(localList);
        }
        visited[src]=true;
        List<Integer> nodes=g.adh[src];
        for(Integer nbr:nodes){
            if(!visited[nbr]){
                localList.add(nbr);
                findAllPathsFromSourceTarget(g,nbr,tgt);
                localList.remove(nbr);
            }
        }
        visited[src]=false;
        return;
    }
}