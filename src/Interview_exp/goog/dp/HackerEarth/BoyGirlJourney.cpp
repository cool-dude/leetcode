#include <bits/stdc++.h>
#define F(i,a,b) for(int i = (int)(a); i <= (int)(b); i++)
#define RF(i,a,b) for(int i = (int)(a); i >= (int)(b); i--)
#define MAX 1005
int Boy1[MAX][MAX];
int Boy2[MAX][MAX];
int Girl1[MAX][MAX];
int Girl2[MAX][MAX];
using namespace std;
int main(){
    int N,M,ans,op1,op2;
    scanf("%d%d",&N,&M);
    int Workout[MAX][MAX];
    ans = 0;

    //Take input the calories burnt matrix
    F(i,1,N)
        F(j,1,M)
            scanf("%d",&Workout[i][j]);

    //Table for Boy's journey from start to meeting cell
    F(i,1,N)
        F(j,1,M)
            Boy1[i][j] = max(Boy1[i-1][j],Boy1[i][j-1]) + Workout[i][j];

    //Table for boy's journey from end to meet cell
    RF(i,N,1)
        RF(j,M,1)
            Boy2[i][j] = max(Boy2[i+1][j],Boy2[i][j+1]) + Workout[i][j];


    //Table for girl's journey from start to meeting cell
    RF(i,N,1)
        F(j,1,M)
            Girl1[i][j] = max(Girl1[i+1][j],Girl1[i][j-1]) + Workout[i][j];


    //Table for girl's journey from end to meeting cell
    F(i,1,N)
        RF(j,M,1)
            Girl2[i][j] = max(Girl2[i-1][j],Girl2[i][j+1]) + Workout[i][j];


    //Now iterate over all meeting positions (i,j)
    F(i,2,N-1)
    {
        F(j,2,M-1)
        {
            //For the option 1
            op1 = Boy1[i][j-1] + Boy2[i][j+1] + Girl1[i+1][j] + Girl2[i-1][j];
            //For the option 2
            op2 = Boy1[i-1][j] + Boy2[i+1][j] + Girl1[i][j-1] + Girl2[i][j+1];
            //Take the maximum of two options at each position
            ans = max(ans,max(op1,op2));
        }
    }
    printf("%d",ans);
    return 0;
}