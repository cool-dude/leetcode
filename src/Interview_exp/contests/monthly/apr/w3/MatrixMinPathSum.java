/*
LC64: Minimum Path Sum
https://leetcode.com/problems/minimum-path-sum/
Given a m x n grid filled with non-negative numbers,
find a path from top left to bottom right
which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.

Example:
Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
*/
class Sln {
    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j!=n-1){
                    grid[i][j]+=grid[i][j+1];
                }
                else if(i!=m-1 && j==n-1){
                    grid[i][j]+=grid[i+1][j];
                }
                else if(i!=m-1 && j!=n-1){
                    grid[i][j]+=Math.min(grid[i+1][j],grid[i][j+1]);
                }
            }
        }
        return grid[0][0];
    }
}