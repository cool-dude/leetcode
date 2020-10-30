#include <bits/stdc++.h>
using namespace std;
void sieve(bool p[],int sz){
    p[0]=false;
    p[1]=false;
    for (int i=2; i*i<=sz; i++){
        if (p[i] == true){
            for (int j=i*2; j<=sz; j += i)
                p[j] = false;
        }
    }
}
int maxLen(int a[],int n){
    int mx=*max_element(a,a+n);
    bool p[mx+1];
    memset(p,true,sizeof(p));
    sieve(p,mx);
    int cur=0;
    mx=0;
    for(int i=0;i<n;i++){
        if(!p[a[i]])
            cur=0;
        else{
            cur++;
            mx=max(cur,mx);
        }
    }
    return mx;
}
int main(){
    int t;
    cin >> t;
    for(int i=0;i<t;i++){
        int n; cin >> n;
        int* a=new int[n];
        for(int i=0;i<n;i++)
            cin >> a[i];
        cout << maxLen(a,n);
    }
}