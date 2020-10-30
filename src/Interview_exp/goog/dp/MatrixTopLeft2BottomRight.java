/*Input:  mat[][] = {{1, 2, 9}
                   {5, 3, 8}
                   {4, 6, 7}}
Output: 4
The longest path is 6-7-8-9*/
class Sln{
    public static int R;
    public static int C;
    static void
    findLongestFromCell(
            int x,int y,int[][] m,int[][] dp) {
        if(x<0||x>=R||y<0||y>=C)
            return;
        else if(dp[i][j]!=-1)
            return;
        else if(j<C-1 &&
                (m[i][j]+1)==m[i][j+1]){
            dp[i][j]=1+
                    findLongestFromCell
                            (i,j+1,m,dp);
            return;
        }
        else if(j>0 &&
                (m[i][j]+1==m[i][j-1])){
            dp[i][j]=1+
                    findLongestFromCell
                            (i,j-1,m,dp);
            return;
        }
        else if(i<R-1 &&
                (m[i][j]+1)==m[i+1][j]){
            dp[i][j]=1+
                    findLongestFromCell
                            (i+1,j,m,dp);
            return;
        }
        else if(i>0 &&
                (m[i][j]+1==m[i-1][j])){
            dp[i][j]=1+
                    findLongestFromCell
                            (i-1,j,m,dp);
            return;
        }
        else{
            dp[i][j]=-1;
            return;
        }
    }

    static int findLongestOverall(int[][] m) {
        int res=1;
        int[][] dp=new int[R][C];

        for(int i=0;i<R;i++)
            for(int j=0;j<C;j++)
                dp[i][j]=-1;

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(dp[i][j]==-1)
                    findLongestFromCell
                            (i,j,m,dp);
                res=Math.max(res,dp[i][j]);
            }
        }
        return res;
    }
}
//T:O(n^2).