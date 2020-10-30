/*LC741: Cherry Pickup
https://leetcode.com/problems/cherry-pickup/
In a N x N grid representing a field of cherries,
each cell is one of three possible integers.
0 means the cell is empty, so you can pass through;
1 means the cell contains a cherry, that you can pick up and pass through;
-1 means the cell contains a thorn that blocks your way.
Your task is to collect maximum number of
cherries possible by following the rules below:
Starting at the position (0, 0) and reaching (N-1, N-1) by moving right or down through valid path cells (cells with value 0 or 1);
After reaching (N-1, N-1), returning to (0, 0) by moving left or up through valid path cells;
When passing through a path cell containing a cherry, you pick it up and the cell becomes an empty cell (0);
If there is no valid path between (0, 0) and (N-1, N-1), then no cherries can be collected.
Example 1:
Input: grid =
[[0, 1, -1],
 [1, 0, -1],
 [1, 1,  1]]
Output: 5
Explanation:
The player started at (0, 0) and went down, down, right right to reach (2, 2).
4 cherries were picked up during this single trip, and the matrix becomes [[0,1,-1],[0,0,-1],[0,0,0]].
Then, the player went left, up, up, left to return home, picking up one more cherry.
The total number of cherries picked up is 5, and this is the maximum possible.
Note:
grid is an N by N 2D array, with 1 <= N <= 50.
Each grid[i][j] is an integer in the set {-1, 0, 1}.
It is guaranteed that grid[0][0] and grid[N-1][N-1] are not -1.*/
class Sln{
    public int cherryPickup(int[][] grid){
        int N=grid.length,M=(N<<1)-1;
        int[][] dp=new int[N][N];
        dp[0][0]=grid[0][0];
        for(int n=1;n<M;n++){
            for(int i=N-1;i>=0;i--){
                for(int p=N-1;p>=0;p--){
                    int j=n-i,q=n-p;
                    if(j<0||j>=N||q<0||q>=N||grid[i][j]<0||grid[p][q]<0){
                        dp[i][p]=-1;
                        continue;
                    }
                    if(i>0) dp[i][p]=Math.max(dp[i][p],dp[i-1][p]);
                    if(p>0) dp[i][p]=Math.max(dp[i][p],dp[i][p-1]);
                    if (i > 0 && p > 0) dp[i][p] = Math.max(dp[i][p], dp[i - 1][p - 1]);
                    if (dp[i][p] >= 0) dp[i][p] += grid[i][j] + (i != p ? grid[p][q] : 0)
                }
            }
        }
        return Math.max(dp[N-1][N-1],0);
    }
}
/*LC1463: Cherry Pickup II
https://leetcode.com/problems/cherry-pickup-ii/
Given a rows x cols matrix grid representing a
field of cherries. Each cell in grid represents
the number of cherries that you can collect.
You have two robots that can collect cherries for
you, Robot #1 is located at the top-left corner (0,0) ,
and Robot #2 is located at the top-right corner (0, cols-1)
of the grid.

Return the maximum number of cherries collection
using both robots  by following the rules below:

From a cell (i,j), robots can move to cell (i+1, j-1) , (i+1, j) or (i+1, j+1).
When any robot is passing through a cell, It picks it up all cherries, and the cell becomes an empty cell (0).
When both robots stay on the same cell, only one of them takes the cherries.
Both robots cannot move outside of the grid at any moment.
Both robots should reach the bottom row in the grid.
Example 1:
Input: grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
Output: 24
Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
Cherries taken by Robot #1, (3 + 2 + 5 + 2) = 12.
Cherries taken by Robot #2, (1 + 5 + 5 + 1) = 12.
Total of cherries: 12 + 12 = 24.

Example 2:
Input: grid = [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]
Output: 28
Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
Cherries taken by Robot #1, (1 + 9 + 5 + 2) = 17.
Cherries taken by Robot #2, (1 + 3 + 4 + 3) = 11.
Total of cherries: 17 + 11 = 28.

Example 3:
Input: grid = [[1,0,0,3],[0,0,0,3],[0,0,3,3],[9,0,3,3]]
Output: 22

Example 4:
Input: grid = [[1,1],[1,1]]
Output: 4
Constraints:
rows == grid.length
cols == grid[i].length
2 <= rows, cols <= 70
0 <= grid[i][j] <= 100*/
class Sln2{
    public int cherryPickup(int[][] grid){
        int m=grid.length,n=grid[0].length;
        Integer[][][] dp=new Integer[m][n][n];
        return dfs(grid,m,n,0,0,n-1,dp);
    }
    int dfs(int[][] grid,int m,int n,int r,int c1,int c2, Integer[][][] dp){
        if(r==m) return 0;
        if(dp[r][c1][c2]!=null) return dp[r][c1][c2];
        int ans=0;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int nc1=c1+i,nc2=c2+j;
                if(nc1>=0 && nc1<n && nc2>=0 && nc2<n){
                    ans=Math.max(ans,dfs(grid,m,n,r+1,nc1,nc2,dp));
                }
            }
        }
        int curCherries=(c1==c2)?grid[r][c1]:grid[r][c1]+grid[r][c2];
        return dp[r][c1][c2]=ans+curCherries;
    }
}