/*Input : mat[][] = {{20, -10, 0},
                   {1, 5, 10},
                   {1, 2, 3}}
Output : 18
(2, 0) ==> (2, 1) ==> (1, 1) ==> (1, 2) ==> (0, 2)
cost for this path is (1+2+5+10+0) = 18

Input : mat[][] = {{1, -2, -3},
                   {1, 15, 10},
                   {1, -2, 3}}
Output : 24*/
class Sln{
    private static final int[][] dirs = {{-1, 0}, {0, 1}};
    class Pair{
        int x,y;
        public Pair(int a,int b){
            x=a;y=b;
        }
    }
    public int maxRevenuePath(int[][] grid){
        int m=grid.length,n=grid[0].length;
        int[][] dp=new int[m][n];
        dp[m-1][0]=grid[m-1][0];

        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(m-1,0));
        while (!q.isEmpty()){
            Pair cur=q.remove();
            for(int[] dir:dirs){
                if(0<=cur.x+dir[0] && cur.x+dir[0]<m && 0<=cur.y+dir[1] && cur.y+dir[1]<n){
                    dp[cur.x+dir[0]][cur.y+dir[1]]=Math.max(dp[cur.x+dir[0]][cur.y+dir[1]],
                                                dp[cur.x][cur.y]+grid[cur.x+dir[0]][cur.y+dir[1]]);
                    q.add(new Pair(cur.x+dir[0],cur.y+dir[1]));
                }
            }
        }
        return dp[0][n-1];
    }
}