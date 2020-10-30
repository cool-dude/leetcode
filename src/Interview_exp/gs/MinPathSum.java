/*LC64. Minimum Path Sum
https://leetcode.com/problems/minimum-path-sum/
*
*
Given a m x n grid filled with non-negative numbers,
* find a path from top left to bottom right which
* minimizes the sum of all numbers along its path.

Example:
Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.*/
/*
* We use an extra matrix dpdp of the same size as the original matrix.
* In this matrix, dp(i, j)dp(i,j) represents the minimum sum
* of the path from the index (i, j)(i,j) to the bottom rightmost
* element. We start by initializing the bottom rightmost element
* of dp as the last element of the given matrix. Then for each element
* starting from the bottom right, we traverse backwards and fill
* in the matrix with the required minimum sums. Now, we need to
* note that at every element, we can move either rightwards or downwards.
Therefore, for filling in the minimum sum, we use the equation:

dp(i, j)= grid}(i,j)+min(dp(i+1,j),dp(i,j+1)

taking care of the boundary conditions.

The following figure illustrates the process:*/
class Sln{
    public int minPathSum(int[][] grid){
        int m=grid.length,nn=grid[0].length;
        int[][] dp=new int[m][n];
        for (int i=m-1;i>=0;i--){
            for (int j=n-1;j>=0;j--){
                if(i==m-1 && j!=n-1) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                }
                else if(i!=m-1 && j==n-1){
                    dp[i][j]=grid[i][j]+dp[i+1][j];
                }
                else if(i!=m-1 && j!=n-1){
                    dp[i][j]=grid[i][j]+Math.min(grid[i+1][j],grid[i][j+1]);
                }
                else{
                    dp[i][j]=grid[i][j];
                }
            }
        }
        return dp[0][0];
    }
    //T:O(MXN).
    //S:O(MXN).
}