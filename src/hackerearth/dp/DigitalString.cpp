#include<bits/stdc++.h>
#pragma GCC optimize ("Ofast")
#pragma GCC optimize("O3")
#define ll long long int
#define FOR(i,a,b) for(ll (i)=(a);i<(ll)(b);i++)
#define rep(i,n) FOR(i,0,n)
#define rep1(i,n) FOR(i,1,n)
#define outi(a) printf("%lld\n",(a))
#define case(i) cout << "Case " << i << ": ";
#define pb push_back
#define in(n) ll n = read();
#define show(arr) for(auto a : arr) cout << a << " "; cout << endl;
#define inp(arr, n) ll arr[n] ; rep(i,n) arr[i] = read();
#define mp make_pair
#define f first
#define s second
#define mod 1000000007
#define test int tt = read(); rep(i,tt) solve(i+1);
using namespace std;
inline ll read()
{
    ll x=0; static int p; p=1; static char c; c=getchar();
    while (!isdigit(c)) { if (c=='-') p=-1; c=getchar(); }
    while ( isdigit(c)) { x=(x<<1)+(x<<3)+(c-48); c=getchar(); }
    x*=p;
    return x;
}
int solve(int ASHIQ);
int main()
{
     test
}
int solve(int tt)
{
    ll n = read();
    ll dp[n][4];
    rep(i, n)
    rep(j, 4) dp[i][j] = 1e8+5;
    inp(arr1, 4);
    rep(i, 4)
    dp[0][i] = arr1[i];
    rep1(i, n)
    {
        inp(arr, 4);
        rep(j, 4)
        {
            rep(k, 4)
            {
                if(k == j) continue;
                dp[i][j] = min(dp[i][j], dp[i-1][k] + arr[j]);

            }
        }
    }
    ll mn = 1e9;
    rep(i, 4)
    mn = min(mn, dp[n-1][i]);

    cout << mn << endl;
    return 0;
}