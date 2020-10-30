#include <bits/stdc++.h>
using namespace std;
#define ll long long int
#define ul unsigned long int
#define F(i,a,b) for(int i = (int)(a); i < (int)(b); i++)
#define RF(i,a,b) for(int i = (int)(a)-1; i >= (int)(b); i--)
#define MOD 1000000007
int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N,M;
    cin >> N >> M;
    int a[N][M];
    F(i,0,N)
        F(j,0,M)
            cin >> a[i][j];
    int nQ;
    cin >> nQ;
    F(i,1,N)
        a[i][0]+=a[i-1][0];
    F(i,1,M)
        a[0][i]+=a[0][i-1];
    F(i,1,M)
        F(j,1,N)
            a[i][j]+=a[i][j-1]+a[i-1][j]-a[i-1][j-1];
    int x,y;
    F(i,0,nQ){
        cin >> x >> y;
        cout << a[x-1][y-1] << endl;
    }
    return 0;
}