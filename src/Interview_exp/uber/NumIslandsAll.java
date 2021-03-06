/*LC200: Number of Islands
https://leetcode.com/problems/number-of-islands/*/
class Sln1{
    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private void dfs(char[][] grid, int r,int c){
        int nr=grid.length;
        int nc=grid[0].length;
        if(r<0||c<0||r>=nr||c>=c||grid[r][c]=='0'){
            return;
        }
        grid[r][c]='0';
        for(int i=0;i<dir.length;i++){
            for(int[] d:dir)
                dfs(grid,r+d[0]),c+d[1]);
        }
    }
    public int numIslands(char[][] grid){
        if(grid==null||grid.length==0){
            return 0;
        }
        int nr=grid.length;
        int nc=grid[0].length;
        int num_islands=0;
        for(int r=0;r<nr;r++){
            for(int c=0;c<nc;c++){
                if(grid[r][c]=='1'||grid[r][c]=='2'){
                    num_islands++;
                    dfs(grid,r,c);
                }
            }
        }
        return num_islands;
    }
    //T:O(mxn).
    //S:O(1) + recursion space
}
/*LC305: Number of Islands II
https://leetcode.com/problems/number-of-islands-ii/
A 2d grid map of m rows and n columns is
initially filled with water. We may perform
an addLand operation which turns the water at
 position (row, col) into a land. Given a
 list of positions to operate, count the
 number of islands after each addLand operation.
 An island is surrounded by water and is
 formed by connecting adjacent lands
 horizontally or vertically. You may
 assume all four edges of the grid are all surrounded by water.
Example:
Input: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
Output: [1,1,2,3]
Explanation:

Initially, the 2d grid grid is filled with water.
(Assume 0 represents water and 1 represents land).
0 0 0
0 0 0
0 0 0
Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

1 0 0
0 0 0   Number of islands = 1
0 0 0
Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

1 1 0
0 0 0   Number of islands = 1
0 0 0
Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

1 1 0
0 0 1   Number of islands = 2
0 0 0
Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

1 1 0
0 0 1   Number of islands = 3
0 1 0
Follow up:
Can you do it in time complexity O(k log mn),
where k is the length of the positions?*/
class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if(m <= 0 || n <= 0) return result;
        int count = 0;                      // number of islands
        int[] roots = new int[m * n];       // one island = one tree
        Arrays.fill(roots, -1);
        for(int[] p : positions) {
            int root = n * p[0] + p[1];     // assume new point is isolated island
            roots[root] = root;             // add new island
            count++;
            for(int[] dir : dirs) {
                int x = p[0] + dir[0];
                int y = p[1] + dir[1];
                int nb = n * x + y;
                if(x < 0 || x >= m || y < 0 || y >= n || roots[nb] == -1) continue;
                int rootNb = findIsland(roots, nb);
                if(root != rootNb) {        // if neighbor is in another island
                    roots[root] = rootNb;   // union two islands
                    root = rootNb;          // current tree root = joined tree root
                    count--;
                }
            }
            result.add(count);
        }
        return result;
    }
    public int findIsland(int[] roots, int id) {
        while(id != roots[id]) {
            roots[id] = roots[roots[id]];   // only one line added
            id = roots[id];
        }
        return id;
    }
}