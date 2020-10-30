#include <bits/stdc++.h>
using namespace std;
#define F(i,a,b) for(int i = (int)(a); i <= (int)(b); i++)
#define RF(i,a,b) for(int i = (int)(a); i >= (int)(b); i--)
int main(){
    int X,Y; //X:number of rows, Y: number of columns
    X = Y = 10; //assuming 10X10 matrix

    int dp[X][Y]; //declare the NumWays matrix
    dp[0][0] = 1;
    // initialize first row of NumWays matrix
    F(j,1,Y-1)
        dp[0][j] = 1;
    //Initialize first column of NumWays Matrix
    F(i,1,X-1)
        dp[i][0] = 1;
    //This bottom-up approach ensures that all the sub-problems needed
    // have already been calculated.
    F(i,1,X-1){
        F(j,1,Y-1){
            //Calculate number of ways visiting (i,j) using the
            //recurrence relation discussed above
            dp[i][j] = dp[i-1][j] + dp[i][j-1];
        }
    }
    cout<<"Number of ways from(0,0) to (X,Y) is "<<dp[X-1][Y-1];
    return 0;
}