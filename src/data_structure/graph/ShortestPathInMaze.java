import java.util.*;
public class ShortestPath{
    static class Point{
        int x,y;
    }
    static class qentry{
        Point p;
        int dist;
    }
    static int getMinDist(int M[][],int n){
        boolean vis[]=new int[n];
        Queue<qentry> q=new LinkedList<>();
        qentry qe=new qentry();
        qe.v=0;
        qe.dist=0;
        vis[0]=true;
        q.add(v);

        while(!q.isEmpty()){
            qe=q.remove();
            int ver=qe.v;

            // If front vertex is the destination
            // vertex, we are done
            if (ver == n - 1)
                break;

            // Otherwise dequeue the front vertex and
            // enqueue its adjacent vertices (or cell
            // numbers reachable through a dice throw)
            for (int j = v + 1; j <= (v + 6) && j < n; ++j){
                // If this cell is already visited, then ignore
                if (visited[j] == false){
                    // Otherwise calculate its distance and
                    // mark it as visited
                    qentry a = new qentry();
                    a.dist = (qe.dist + 1);
                    visited[j] = 1;
                    // Check if there a snake or ladder at 'j'
                    // then tail of snake or top of ladder
                    // become the adjacent of 'i'
                    if (move[j] != -1)
                        a.v = move[j];
                    else
                        a.v = j;
                    q.add(a);
                }
            }
        }
        return q.dist;
    }
}