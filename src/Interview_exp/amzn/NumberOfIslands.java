/*LC200: Number of Islands
https://leetcode.com/problems/number-of-islands/
* Given a 2d grid map of '1's
* (land) and '0's (water),
* count the number of islands.
* An island is surrounded by water
* and is formed by connecting
* adjacent lands horizontally
* or vertically.

Example 1:
Input:
11110
11010
11000
00000
Output: 1

* Example 2:
Input:
11000
11000
00100
00011
Output: 3*/
class Sln{
    static final int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    void dfs(char[][] grid, int r,int c){
        int nr=grid.length;
        int nc=grid[0].length;
        if(r<0||c<0||r>=nr||c>=c||grid[r][c]=='0'){
            return;
        }
        grid[r][c]='0';
        for(int[] d:dir)
            dfs(grid,r+d[0]),c+d[1]);
    }
    public int numIslands(char[][] grid){
        if(grid==null||grid.length==0){
            return 0;
        }
        int r=grid.length;
        int c=grid[0].length;
        int num_islands=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1'){
                    num_islands++;
                    dfs(grid,i,j);
                }
            }
        }
        return num_islands;
    }
    //T:O(mxn).
    //S:O(1) + recursion space
}