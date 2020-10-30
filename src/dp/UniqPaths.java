/*LC62: Unique Paths
https://leetcode.com/problems/unique-paths/
A robot is located at the top-left
corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any
point in time. The robot is trying to reach the
bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
Above is a 7 x 3 grid. How many possible unique paths are there?

Example 1:
Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
Example 2:
Input: m = 7, n = 3
Output: 28*/
class Sln {
    public static void main(String[] args) {
        UniquePaths_62 up = new UniquePaths_62();
        System.out.println(up.uniquePaths(3,2));
    }
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(i==1 && j==1)
                    cache[i][j]=1;
                else
                    cache[i][j]=cache[i-1][j]+cache[i][j-1];
            }
        }
        return cache[m][n];
    }
}
/*LC63: Unique Paths II
* https://leetcode.com/problems/unique-paths-ii/
A robot is located at the top-left corner
* of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at
* any point in time. The robot is trying to
* reach the bottom-right corner of the grid (marked
* 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?


An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Example 1:
Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right*/
class Sln2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1)
            return 0;
        obstacleGrid[0][0] = 1;
        // Filling values first column
        for (int i = 1; i < R; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }
        // Filling values first row
        for (int i = 1; i < C; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[R - 1][C - 1];
    }
}