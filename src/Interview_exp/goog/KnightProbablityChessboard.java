/*LC688: Knight Probability in Chessboard
On an NxN chessboard, a knight starts at the
* r-th row and c-th column and attempts to
* make exactly K moves. The rows and columns
* are 0 indexed, so the top-left square is (0, 0),
*  and the bottom-right square is (N-1, N-1).

A chess knight has 8 possible moves it can make,
*  as illustrated below. Each move is two squares
* in a cardinal direction, then one square in an orthogonal direction.


Each time the knight is to move, it chooses one of
* eight possible moves uniformly at random (even if t
* he piece would go off the chessboard) and moves there.

The knight continues moving until it has made exactly
* K moves or has moved off the chessboard. Return the
* probability that the knight remains on the board after it has stopped moving.*/
class Sln1Recursive {
    int[][] dir = new int[][]{{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
    double helper(int N, int K, int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= N) return 0;
        if (K == 0) return 1;
        double rate = 0;
        for (int i = 0; i < dir.length; i++)
            rate += 0.125 * helper(N, K - 1, r + dir[i][0], c + dir[i][1]);
        return rate;
    }
    public double knightProbability(int N, int K, int r, int c) {
        return helper(N, K, r, c);
    }
}


class Sln2DP{
    int[][] dir=new int[][]{{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2}};
    double[][][] dp;
    double findProbablity(int N,int K,int r,int c){
        if(r<0||r>=N||c<0||c>=N) return 0;
        if(K==0) return 1;
        if(dp[r][c][K]>0) return dp[r][c][K];
        double rate=0;
        for(int i=0;i<dir.length;i++)
            rate+=0.125*findProbablity(N,K-1,r+dir[i][0],c+dir[i][1]);
        dp[r][c][K]=rate;
        return rate;
    }
    public double knnightProbablity(int N,int K,int r,int c){
        dp=new double[N][N][K+1];
        return findProbablity(N,K,r,c);
    }
}