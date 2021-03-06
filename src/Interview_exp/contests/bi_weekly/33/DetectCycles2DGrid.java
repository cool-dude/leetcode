/*LC1559: Detect Cycles in 2D Grid
https://leetcode.com/problems/detect-cycles-in-2d-grid/
Given a 2D array of characters grid of size m x n,
you need to find if there exists any cycle consisting
of the same value in grid.

A cycle is a path of length 4 or more in the grid
that starts and ends at the same cell. From a given cell,
you can move to one of the cells adjacent to it - in one
of the four directions (up, down, left, or right),
if it has the same value of the current cell.

Also, you cannot move to the cell that you visited
in your last move. For example, the cycle (1, 1) -> (1, 2) -> (1, 1)
is invalid because from (1, 2) we visited (1, 1)
which was the last visited cell.

Return true if any cycle of the same value exists
in grid, otherwise, return false.

Example 1:
Input: grid = [["a","a","a","a"],["a","b","b","a"],["a","b","b","a"],["a","a","a","a"]]
Output: true
Explanation: There are two valid cycles shown in different colors in the image below:

Example 2:
Input: grid = [["c","c","c","a"],["c","d","c","c"],["c","c","e","c"],["f","c","c","c"]]
Output: true
Explanation: There is only one valid cycle highlighted in the image below:

Example 3:
Input: grid = [["a","b","b"],["b","z","b"],["b","b","a"]]
Output: false
Constraints:
m == grid.length
n == grid[i].length
1 <= m <= 500
1 <= n <= 500
grid consists only of lowercase English letters.*/
class Sln{
    int[] DIR_X = {1, -1, 0, 0};
    int[] DIR_Y = {0, 0, 1, -1};
    private boolean dfs(int curX, int curY, int lastX, int lastY, int n, int m, boolean[][] vis, char[][] grid, char startChar) {
        vis[curX][curY] = true;
        boolean hasCycle = false;
        // Visit all directions
        for (int i = 0; i < 4; ++i) {
            int newX = curX + DIR_X[i];
            int newY = curY + DIR_Y[i];
            // Valid point?
            if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                // Don't visit last visited point
                if (!(newX == lastX && newY == lastY)) {
                    // Only visit nodes that equal start character
                    if (grid[newX][newY] == startChar) {
                        if (vis[newX][newY]) {
                            // Still visited? There is a cycle.
                            return true;
                        } else {
                            hasCycle |= dfs(newX, newY, curX, curY, n, m, vis, grid, startChar);
                        }
                    }
                }
            }
        }
        return hasCycle;
    }
    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        boolean hasCycle = false;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (!vis[i][j]) {
                    hasCycle |= dfs(i, j, -1, -1, n, m, vis, grid, grid[i][j]);
                }
            }
        }
        return hasCycle;
    }
}