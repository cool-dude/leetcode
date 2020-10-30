/*LC1091: Shortest Path in Binary Matrix
In an N by N square grid, each cell
* is either empty (0) or blocked (1).

A clear path from top-left to bottom-right
* has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:

Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
C_1 is at location (0, 0) (ie. has value grid[0][0])
C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.*/
class Soln{
    int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public int shortestPathBinaryMatrix(int[][] grid){
        int m=grid.length;
        if(grid[0][0]!=0||grid[m-1][m-1]!=0) return -1;
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{0,0});
        grid[0][0]=1;
        int res=1;
        while (!q.isEmpty()){
            for(int i=q.size();i>0;i--){
                int[] cur=q.poll();
                if(cur[0]==cur[1] && cur[0]==m-1) return res;
                for(int[] d:dir){
                    int x=d[0]+cur[0];
                    int y=d[1]+cur[1];
                    if(x>=0 && x<m && y>=0 && y<m && grid[x][y]==0){
                        q.offer(new int[]{x,y});
                        grid[x][y]=1;
                    }
                }
            }
            res++;
        }
        return -1;
    }
    int[][] dir=new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
    public int shortestPathBinaryMaze(int[][] grid){
        int m=grid.length;
        if(grid[0][0]!=0||grid[m-1][m-1]!=0) return -1;
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{0,0});
        grid[0][0] = 1;
        int res = 1;
        while (!q.isEmpty()){
            for(int i=0;i<q.size();i++){
                int[] cur = q.poll();
                if(cur[0] == cur[1] && cur[1] == m-1) return res;
                for(int[] d:dir){
                    int x = d[0]+cur[0];
                    int y = d[1]+cur[1];
                    if(x>=0 && x<m && y>=0 && y<m && grid[x][y] == 0){
                        q.offer(new int[]{x,y});
                        grid[x][y]=1;
                    }
                }
            }
            res++;
        }
        return -1;
    }
}