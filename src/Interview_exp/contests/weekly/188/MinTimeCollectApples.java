/*LC1443:Minimum Time to Collect All Apples in a Tree
https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/
Given an undirected tree consisting of n vertices
numbered from 0 to n-1, which has some apples in
their vertices. You spend 1 second to walk over
one edge of the tree. Return the minimum time in
seconds you have to spend in order to collect all
apples in the tree starting at vertex 0 and coming
back to this vertex.

The edges of the undirected tree are given in the array edges,
where edges[i] = [fromi, toi] means that exists an
edge connecting the vertices fromi and toi. Additionally,
there is a boolean array hasApple, where
hasApple[i] = true means that vertex i has an apple,
otherwise, it does not have any apple.

Example 1:
Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,true,true,false]
Output: 8
Explanation: The figure above represents the given tree where red vertices have an apple. One optimal path to collect all apples is shown by the green arrows.

Example 2:
Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,false,true,false]
Output: 6
Explanation: The figure above represents the given tree where red vertices have an apple. One optimal path to collect all apples is shown by the green arrows.

Example 3:
Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,false,false,false,false,false]
Output: 0*/
class Sln {
    int dfs(Map<Integer, List<Integer>> graph,int node, List<Boolean> hasApple,int curCost){
        int childCost=0;
        for(int n:graph.getOrDefault(node,new ArrayList<>())){
            childCost+=dfs(graph,n,hasApple,2);//check for all apples in subtrees
        }
        if(childCost==0 && hasApple.get(node)==false){
            return 0;
        }
        return childCost+curCost;
    }
    Map<Integer,List<Integer>> createGraph(int[][] edges){
        Map<Integer,List<Integer>> g=new HashMap<>();
        for(int[] e:edges){
            List<Integer> l=g.getOrDefault(e[0],new ArrayList<>());
            l.add(e[1]);
            g.put(e[0],l);
        }
        return g;
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> graph = createGraph(edges); // to store the graph
        return dfs(graph, 0, hasApple, 0);
    }
}