/*Print all leaf nodes of n-ary tree
Input: edge[][] = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}}
Output: 4 5 6
    1
   / \
  2   3
 / \   \
4   5   6

Input: edge[][] = {{1, 5}, {1, 7}, {5, 6}}
Output: 6 7*/
// Java implementation of the approach
import java.util.*;
class Sln {
    static class pair {
        int first,second;
        pair(int a, int b) {
            first = a;
            second = b;
        }
    }
    static void dfs(Vector t, int node, int parent) {
        int flag = 1;
        for (int i = 0; i < ((Vector)t.get(node)).size(); i++) {
            int ir = (int)((Vector)t.get(node)).get(i);
            if (ir != parent) {
                flag = 0;
                dfs(t, ir, node);
            }
        }
        if (flag == 1)
            System.out.print( node + " ");
    }
    public static void main(String args[]) {
        Vector t = new Vector();
        pair edges[] = { new pair( 1, 2 ),
                new pair( 1, 3 ),
                new pair( 2, 4 ),
                new pair( 3, 5 ),
                new pair( 3, 6 ),
                new pair( 3, 7 ),
                new pair( 6, 8 ) };
        int cnt = edges.length;
        int node = cnt + 1;
        for(int i = 0; i < 1005; i++) {
            t.add(new Vector());
        }
        for (int i = 0; i < cnt; i++) {
            ((Vector)t.get(edges[i].first)).add(edges[i].second);
            ((Vector)t.get(edges[i].second)).add(edges[i].first);
        }
        dfs(t, 1, 0);
    }
}