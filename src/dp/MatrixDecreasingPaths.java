
class Sln{
    int MOD = 1_000_000_007;
    int[][] dirs={{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int countPathsHelper(int[][] mat,int[][] dp,int n,int x,int y) {
        if (dp[x][y] != -1)
            return dp[x][y] % MOD;
        int ans = 0;
        for (int[] dir : dirs) {
            int nx=x+dir[0];
            int ny=y+dir[1];
            if(0<=nx && nx<n && 0<=ny && ny<n && mat[nx][ny] < mat[x][y])
                ans+=countPathsHelper(mat,dp,n,nx,ny);
        }
        dp[x][y]=ans%MOD;
        return dp[x][y];
    }
    public int countDecreasingPaths(int[][] mat){
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                dp[i][j]=-1;
        int sum=0;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                sum+=countPathsHelper(mat,dp,n,i,j);
        return sum%MOD;
    }
    //T:O(n^2).
    //S:O(n^2).
}