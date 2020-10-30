import java.io.*;
import java.util.*;
public class Sln {
    // An entry in queue used in BFS
    static class qentry {
        int v;// Vertex number
        int dist;// Distance of this vertex from source
    }
    static int getMinDiceThrows(int move[], int n) {
        boolean visited[] = new boolean[n];
        Queue<qentry> q = new LinkedList<>();
        qentry qe = new qentry();
        qe.v = 0;
        qe.dist = 0;
        // Mark the node 0 as visited and enqueue it.
        visited[0] = true;
        q.add(qe);
        // Do a BFS starting from vertex at index 0
        while (!q.isEmpty()) {
            qe = q.remove();
            int v = qe.v;
            if (v == n - 1){
                return qe.dist;
            }
            for (int j = v + 1; j <= (v + 6) && j < n; j++) {
                // If this cell is already visited, then ignore
                if (visited[j] == false) {
                    qentry a = new qentry();
                    a.dist = (qe.dist + 1);
                    visited[j] = true;

                    if (move[j] != -1)
                        a.v = move[j];
                    else
                        a.v = j;
                    q.add(a);
                }
            }
        }
        //not ordinarily reach
        return -1;
    }
    public static void main(String[] args) {
        // Let us construct the board given in above diagram
        int N = 25;
        int moves[] = new int[N];
        Arrays.fill(moves,-1);

        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;

        System.out.println("Min Dice throws required is " +
                getMinDiceThrows(moves, N));
    }
}