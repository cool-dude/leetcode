/*
* LC1391: Check if There is a Valid Path in a Grid
* https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/
User Accepted:1770
User Tried:2460
Total Accepted:1819
Total Submissions:5049
Difficulty:Medium
Given a m x n grid. Each cell of the grid represents a street. The street of grid[i][j] can be:
1 which means a street connecting the left cell and the right cell.
2 which means a street connecting the upper cell and the lower cell.
3 which means a street connecting the left cell and the lower cell.
4 which means a street connecting the right cell and the lower cell.
5 which means a street connecting the left cell and the upper cell.
6 which means a street connecting the right cell and the upper cell.*/
class Sln{
    int[][][] DIR = new int[][][]{
            {{-1, 0}, {1, 0}}, //Street 2
            {{0, -1}, {0, 1}}, //Street 1
            {{0, -1}, {1, 0}},
            {{0, 1}, {1, 0}},
            {{0, -1}, {-1, 0}},
            {{-1, 0}, {0, 1}}
    };
    boolean dfs(int[][] grid, int m,int n,int r,int c,boolean[][] visited){
        if(r==m-1 && c==n-1) return true;
        visited[r][c]=true;
        for(int[] nextDir:DIR[grid[r][c]-1]){
            int nr=r+nextDir[0];
            int nc=c+nextDir[1];
            if(nr<0||nr>=m||nc<0||nc>=n||visited[nr][nc]) continue;
            //check new cell can go back to current
            for(int[] backDir:DIR[grid[nr][nc]-1]){
                if(nr+backDir[0]==r && nc+backDir[1]==c){
                    if(dfs(grid,m,n,nr,nc,visited)) return true;
                }
            }
        }
        return false;
    }
    public boolean hasValidPath(int[][] grid){
        if(grid[0][0]==4||grid[0][0]==5)
            return false;
        int m=grid.length;
        int n=grid[0].length;
        if(grid[m-1][n-1]==4||grid[m-1][n-1]==5)
            return false;
        boolean[][] vis=new boolean[m][n];
        return dfs(grid,m,n,0,0,vis);
    }
}


class Sln2{
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(grid, m, n, 0, 0, visited);
    }
    int[][][] DIR = new int[][][]{
            {{0, -1}, {0, 1}},
            {{-1, 0}, {1, 0}},
            {{0, -1}, {1, 0}},
            {{0, 1}, {1, 0}},
            {{0, -1}, {-1, 0}},
            {{-1, 0}, {0, 1}}
    };
    boolean dfs(int[][] grid, int m, int n, int r, int c, boolean[][] visited) {
        if (r == m - 1 && c == n - 1) return true; // Reach bottom-right cell -> Valid path
        visited[r][c] = true;
        for (int[] nextDir : DIR[grid[r][c] - 1]) {
            int nr = r + nextDir[0], nc = c + nextDir[1];
            if (nr < 0 || nr >= m || nc < 0 || nc >= n || visited[nr][nc]) continue;
            for (int[] backDir : DIR[grid[nr][nc] - 1]) { // Check next cell can go back to current cell
                if (nr + backDir[0] == r && nc + backDir[1] == c) {
                    if (dfs(grid, m, n, nr, nc, visited)) return true;
                }
            }
        }
        return false;
    }
}