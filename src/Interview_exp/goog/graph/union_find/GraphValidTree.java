/*LC261: Graph Valid Tree
https://leetcode.com/problems/graph-valid-tree/
Given n nodes labeled from 0 to n-1
and a list of undirected edges (each
edge is a pair of nodes), write a
function to check whether these edges make up a valid tree.
Example 1:
Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
Output: true

Example 2:
Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
Output: false
Note: you can assume that no duplicate edges will
appear in edges. Since all edges are undirected,
[0,1] is the same as [1,0] and thus will not appear together in edges.*/
class Sln{
    public boolean validTree(int n,int[] edges){
        int[] nums=new int[n];
        Arrays.fill(nums,-1);
        for(int i=0;i<edges.length;i++){
            int x=find(nums,edges[i][0]);
            int y=find(nums,edges[i][1]);
            if(x==y) return false;
            nums[x]=y;
        }
        return edges.length==n-1;
    }
    int find(int[] nums,int i){
        if(nums[i]==-1) return i;
        return find(nums,nums[i]);
    }
}