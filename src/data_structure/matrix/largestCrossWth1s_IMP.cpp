#include <bits/stdc++.h>
using namespace std;

//fun to find largest plus
int findLargestPlus(int m[N][N])
{
	int lft[N][N],rgt[N][N],top[N][N],bot[N][N];
	
	for(int i=0;i<N;i++){
		top[0][i]=m[0][i];
		bot[N-1][i]=m[N-1][i];
		lft[i][0]=m[i][0];
		rgt[i][N-1]=m[i][N-1];
	}
	
	for(int i=0;i<N;i++){
		for(int j=1;j<N;j++){
			if(m[i][j]==1)
				lft[i][j]=lft[i][j-1]+1;
			else
				lft[i][j]=0;
			
			if(m[j][i]==1)
				top[j][i]=top[j-1][i]+1;
			else
				top[j][i]=0;
			
			//cal bot and rght(i,j)
			j=N-1-j;
			if(m[j][i]==1)
				bot[j][i]=bot[j+1][i]+1;
			else
				bot[j][i]=0;
			
			if(m[i][j]==1)
				rgt[i][j]=rgt[i][j+1]+1;
			else
				rgt[i][j]=0;
			//revert j
			j=N-1-j;
		}
	}
	max_now=0;
	
	for(int i=0;i<N;i++){
		for(int j=0;j<N;j++){
			int len=min(min(top[i][j], bot[i][j]),
						min(lft[i][j], rgt[i][j]));
			if(len>max_now)
				max_now=len;
		}
	}
	if(max_now)
		return 4*(max_now-1)+1;
	return 0;
}