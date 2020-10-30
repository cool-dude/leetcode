/*LC1444: Number of Ways of Cutting a Pizza
https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/
Given a rectangular pizza represented as rows x cols
matrix containing the following characters: 'A' (an apple)
and '.' (empty cell) and given the integer k.
You have to cut the pizza into k pieces using k-1 cuts.

For each cut you choose the direction: vertical/horizontal,
then you choose a cut position at the cell boundary and
cut the pizza into two pieces. If you cut the pizza
vertically, give the left part of the pizza to a person.
If you cut the pizza horizontally, give the upper part
of the pizza to a person. Give the last piece of pizza
to the last person.

Return the number of ways of cutting the pizza such t
hat each piece contains at least one apple.
Since the answer can be a huge number, return this modulo 10^9 + 7.

Example 1:
Input: pizza = ["A..","AAA","..."], k = 3
Output: 3
Explanation: The figure above shows the three ways to cut the pizza. Note that pieces must contain at least one apple.

Example 2:
Input: pizza = ["A..","AA.","..."], k = 3
Output: 1

Example 3:
Input: pizza = ["A..","A..","..."], k = 1
Output: 1*/
class Solution {
    int MOD = 1_000_000_007;
    int dfs(int m,int n,int k,int r,int c,int[][][] dp,int[][] preSum){
        if(preSum[r][c]==0) return 0;//remaininng pieces no apple,no cuts possible
        if(k==0) return 1;
        if(dp[k][r][c]!=0) return dp[k][r][c];
        int ans=0;
        //cut horiz
        for(int nr=r+1;nr<m;nr++)
            if(preSum[r][c]-preSum[nr][c]>0)//cut upper piece contains atleast one apple
                ans=(ans+dfs(m,n,k-1,nr,c,dp,preSum))%MOD;
        //cut vert
        for(int nc=c+1;nc<n;nc++)
            if(preSum[r][c]-preSum[r][nc]>0)//cut if left piece contains atlest one apple
                ans=(ans+dfs(m,n,k-1,r,nc,dp,preSum))%MOD;
        return dp[k][r][c]=ans;
    }
    public int ways(String[] pizza,int k){
        int m=pizza.length;
        int n=pizza[0].length();
        int[][][] dp=new int[k][m][n];
        int[][] preSum=new int[m+1][n+1];//preSum[r][c]:total number of apples in pizza[r:][c:]
        for(int r=m-1;r>=0;r--)
            for(int c=n-1;c>=0;c--)
                preSum[r][c]=preSum[r][c+1]+preSum[r+1][c]-preSum[r+1][c+1]+(pizza[r].charAt(c)=='A'?1:0);
        return dfs(m,n,k-1,0,0,dp,preSum);
    }
    //T:O(k*m*n*(m+n)).
    //S:O(k*m*n).
}