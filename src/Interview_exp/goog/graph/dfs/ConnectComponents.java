package data_structure.graph.week1;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
/*LC323. Number of Connected Components in an Undirected Graph
* https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
Given n nodes labeled from 0 to n - 1 and a
list of undirected edges (each edge is a pair of nodes),
* write a function to find the number of
* connected components in an undirected graph.
Example 1:
Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]

     0          3
     |          |
     1 --- 2    4
Output: 2
Example 2:

Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]

     0           4
     |           |
     1 --- 2 --- 3

Output:  1
Note:
You can assume that no duplicate edges will appear in edges.
* Since all edges are undirected, [0, 1] is
* the same as [1, 0] and thus will not appear together in*/
class Sln{
    void dfs(List<Integer>[] adj, int start, boolean[] visited){
        List<Integer> nbrs=adj[start];
        for(int nbr:nbrs){
            if(!visited[nbr]){
                visited[nbr]=true;
                dfs(adj, nbr, visited);
            }
        }
    }
    public int numConnectedComponents(List<Integer>[] adj){
        boolean[] visited=new boolean[adj.length+1];
        int result=0;
        for(int i=0;i<adj.length;i++){
            if(!visited[i]) {
                visited[i]=true;
                dfs(adj, i, visited);
                result++;
            }
        }
    }
}

class Sln2{

}