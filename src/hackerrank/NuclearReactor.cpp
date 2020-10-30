https://www.hackerrank.com/contests/codeagon-15-16/challenges/nuclear-reactor/problem
http://codeforces.com/contest/346/status
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
#include <bits/stdc++.h>
using namespace std;
typedef long long int lld;
const lld N = 200043;
const lld MOD = 1000000007;
lld add(lld x, lld y)
{
    x =((x%MOD)+(y%MOD))%MOD;
    while(x >= MOD) x -= MOD;
    while(x < 0) x += MOD;
    return x;
}

lld mul(lld x, lld y)
{
    return ((x%MOD)*(y%MOD))% MOD;
}

lld binpow(lld x, lld y)
{
    lld z = 1;
    while(y)
    {
        if(y & 1) z = mul(z, x);
        x = mul(x, x);
        y >>= 1;
    }
    return z;
}

lld inv(lld x)
{
    return binpow(x, MOD - 2);
}

lld divide(lld x, lld y)
{
    return mul(x, inv(y));
}

lld dp[105][105][105];
lld pi[105]={0};
string str,ptr,gtr;
lld n,m,s;
lld kmp(lld l,char ch)
{
    while(l>0 && ch!=gtr[l])
        l=pi[l-1];
    if(ch==gtr[l])
        l++;
    return l;
}

lld fun(lld a, lld b, lld c)
{
    if(c==s)
        return INT_MIN;
    if(a==n || b==m)
        return 0;
    if(dp[a][b][c]!=-1)
        return dp[a][b][c];
    lld ans=0;
    ans=max(fun(a,b+1,c),ans);
    ans=max(fun(a+1,b,c),ans);
    if(str[a]==ptr[b])
    {
        lld temp=kmp(c,str[a]);
        ans=max(fun(a+1,b+1,temp)+1,ans);
    }
    dp[a][b][c]=ans;
    return ans;
}

void scan(lld a, lld b, lld c)
{
    if(a==n || b==m)
        return;
    lld ans=fun(a,b,c);
    if(ans==fun(a,b+1,c))
        return scan(a,b+1,c);
    if(ans==fun(a+1,b,c))
        return scan(a+1,b,c);
    cout<<str[a];
    scan(a+1,b+1,kmp(c,str[a]));
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    lld t;
    //cin>>t;
    t=1;
    while(t--){
        memset(dp,-1,sizeof(dp));
        cin>>str;
        n=str.length();
        cin>>ptr;
        m=ptr.length();
        cin>>gtr;
        s=gtr.length();
        lld l=0;
        for(int i=1;i<n;i++){
            lld l=kmp(l,gtr[i]);
            pi[i]=l;
        }
        lld ans=fun(0,0,0);
        cout << ans << endl;
    }
}