class Solution {
    int[][] dp;
    Integer[] memo;
    public int maxSumAfterPartitioning(int[] A, int K) {
        int n = A.length;
        dp = new int[n][n];
        memo = new Integer[n+1];
        for(int i = 0 ; i < n ; i++){
            dp[i][i] = A[i];
            for(int j = i+1 ; j < n ; j++) dp[i][j] = dp[i][j-1] < A[j] ? A[j] : dp[i][j-1];
        }
        return helper(0,K,n);
    }
    public  int helper(int start , int k, int n){
        if(memo[start]!=null) return memo[start];
        int res = 0 ;
        for(int i = start; i < start+k  && i < n; i++)
            res = Math.max(dp[start][i]*(i-start+1) + helper(i+1,k,n),res);
        memo[start] = res;
        return res;
    }
}


class Soln{
    int[][] dp;
    Integer[] memo;
    private int helper(int start, int k, int n){
        if(memo[start]!=null) return memo[start];
        int res=0;
        for(int i=start;i<start+k && i<n;i++){
            res = Math.max(dp[start][i]*(i-start+1) + helper(i+1, k, n), res);
        }
        memo[start]=res;
        return res;
    }
    public int maxSumAfterPartitioning(int[] A,int K){
        int n=A.length;
        dp = new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i] = A[i];
            for(int j=i+1;j<n;j++)
                dp[i][j]=dp[i][j-1]<A[j]?A[j]:dp[i][j-1];
        }
    }
}