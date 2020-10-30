/*LC1254: Number of Closed Islands
https://leetcode.com/problems/number-of-closed-islands/
Given a 2D grid consists of 0s (land) and 1s (water).
An island is a maximal 4-directionally connected
group of 0s and a closed island is an island
totally (all left, top, right, bottom) surrounded by 1s.
Return the number of closed islands.
Example 1:
Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
Output: 2
Explanation:
Islands in gray are closed because they are completely surrounded by water (group of 1s).

Example 2:
Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
Output: 1

Example 3:
Input: grid = [[1,1,1,1,1,1,1],
               [1,0,0,0,0,0,1],
               [1,0,1,1,1,0,1],
               [1,0,1,0,1,0,1],
               [1,0,1,1,1,0,1],
               [1,0,0,0,0,0,1],
               [1,1,1,1,1,1,1]]
Output: 2
Constraints:
1 <= grid.length, grid[0].length <= 100
0 <= grid[i][j] <=1
Approach 1: Flood Fill
First, we need to remove all land connected to the edges using flood fill.
Then, we can count and flood-fill the remaining islands.*/
class Sln {
    int fill(int[][] g,int i,int j){
        if(i<0||j<0||i>=g.length||j>=g[0].length||g[i][j]!=0)
            return 0;
        return (g[i][j]=1)+fill(g,i+1,j)+fill(g, i,j+1)+fill(g,i-1,j)+fill(g,i,j-1);
    }
    public int closedIsland(int[][] grid) {
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
                if(i*j*(i- grid.length+1)*(j-grid[0].length+1)==0)
                    fill(grid,i,j);
        int res=0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
                res+=fill(grid,i,j)>0?1:0;
        return res;
    }
    //T:O(mXn).
    //S:O(1)
}