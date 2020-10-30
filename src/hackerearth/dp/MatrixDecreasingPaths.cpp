#include <bits/stdc++.h>
using namespace std;
#define ll long long int
#define ul unsigned long int
#define F(i,a,b) for(int i = (int)(a); i < (int)(b); i++)
#define RF(i,a,b) for(int i = (int)(a)-1; i >= (int)(b); i--)
#define MOD 1000000007
#define MAX 1000
int CountDecreasingPaths(int n,int mat[MAX][MAX],unsigned long dp[MAX][MAX],int x,int y){
    if(dp[x][y]!=-1)
        return dp[x][y];
	ul ans=1;
	int dirs[4][2] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	F(i,0,4)
	{
		int nx=x+dirs[i][0];
		int ny=y+dirs[i][1];
		if(nx>=0 && nx<n && ny>=0 && ny<n && mat[nx][ny]<mat[x][y])
			ans+=CountDecreasingPaths(n,mat,dp,nx,ny)%MOD;
	}
	dp[x][y]=ans%MOD;
	return dp[x][y];
}
int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
	int n;
    cin>>n;
	int mat[MAX][MAX];
	ul dp[MAX][MAX];

    F(i,0,n)
        F(j,0,n)
            cin >> mat[i][j];
    memset(dp,-1,sizeof(dp));
    ul res=0;
    F(i,0,n)
	{
        F(j,0,n)
		{
            res+=CountDecreasingPaths(n,mat,dp,i,j);
        }
    }
    cout << res%MOD << endl;
	return 0;
}