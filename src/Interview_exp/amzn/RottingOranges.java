/*LC994: Rotting Oranges
https://leetcode.com/problems/rotting-oranges
the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must
elapse until no cell has a fresh orange.
If this is impossible, return -1 instead.

Example 1:
Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:
Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner
(row 2, column 0) is never rotten,
because rotting only happens 4-directionally.

Example 3:
Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.*/
class Sln{
    public int orangesRotting(int[][] grid){
        if(grid==null||grid.length==0) return 0;
        int m=grid.length,n=grid[0].length;
        Queue<int[]> rotted=new LinkedList<int[]>();
        int fresh=0;
        for(int i=0;i<m;i++) {
            for (int j=0; j<n;j++) {
                if(grid[i][j]==2) rotted.add(new int[]{i,j});
                if(grid[i][j]==1) fresh++;
            }
        }
        if(fresh==0) return 0;
        int[][] dirs={{1,0},{0,-1},{-1,0},{0,1}};
        int time=0;
        while (!rotted.isEmpty()){
            Queue<int[]> t=new LinkedList<int[]>();
            int sz=rotted.size();
            for(int i=0;i<sz;i++){
                int[] rotten=rotted.poll();
                for(int[] dir:dirs){
                    int nx=rotten[0]+dir[0];
                    int ny=rotten[1]+dir[1];
                    if(0<=nx && nx<m && 0<=ny && ny<n && grid[nx][ny]==1){
                        grid[nx][ny]=2;
                        t.add(new int[]{nx,ny});
                        fresh--;
                    }
                }
            }
            time++;
            rotted=t;
        }
        if(fresh>0) return 0;
        return time-1;
    }
}
/*Zombie in matrix
https://leetcode.com/discuss/interview-question/411357/
Given a 2D grid, each cell is either a zombie 1
or a human 0. Zombies can turn adjacent
(up/down/left/right) human beings into
zombies every hour. Find out how many hours does it take to infect?
Example:
Input:
[[0, 1, 1, 0, 1],
 [0, 1, 0, 1, 0],
 [0, 0, 0, 0, 1],
 [0, 1, 0, 0, 0]]
Output: 2
Explanation:
At the end of the 1st hour, the status of the grid:
[[1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [0, 1, 0, 1, 1],
 [1, 1, 1, 0, 1]]

At the end of the 2nd hour, the status of the grid:
[[1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1]]
 */
class Sln{
    public int minHours(int rows, int columns, List<List<Integer>> grid){
        Queue<int[]> zombies=new ArrayDeque<>();
        int fresh=0;
        for(int r=0;r<rows;r++)
            for (int c = 0; c < columns; c++)
                if (grid.get(r).get(c) == 2) zombies.add(new int[]{r,c});
        int[][] dirs={{1,0},{0,-1},{-1,0},{0,1}};
        int time=0;
        while (!zombies.isEmpty()){
            Queue<int[]> temp=new ArrayDeque<>();
            int sz=zombies.size();
            for(int i=0;i<sz;i++){
                int[] rotten=zombies.remove();
                for(int[] dir:dirs){
                    int nx=rotten[0]+dir[0];
                    int ny=rotten[1]+dir[1];
                    if(0<=nx && nx<m && 0<=ny && ny<n && grid[nx][ny]==1) {
                        grid.get(nx).set(ny)=2;
                        temp.offer(new int[]{nx, ny});
                    }
                }
            }
            zombies=temp;
            time++;
        }
        return time-1;
    }
}

/*LC286: Walls and Gates
* https://leetcode.com/problems/walls-and-gates/
You are given a m x n 2D grid initialized with
* these three possible values.
-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value
* 2^31 - 1 = 2147483647 to represent INF as you may
* assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its
* nearest gate. If it is impossible to reach a gate, it should be filled with INF.

Example:
Given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4*/
