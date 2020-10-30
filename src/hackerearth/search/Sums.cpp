#include <iostream>
#include <cmath>
//#include "bits/stdc++.h"
using namespace std;
#define ll long long int
#define MOD 1000000007
#define MAX 1000000000
ll decToBin(ll n,ll dp[]){
    if(n<MAX){ if(dp[n-1]!=0) return dp[n-1];}
    ll res=0,count=0;
    while(n!=0){
        int rem=n%2;
        double c=pow(10,count);
        res+=rem*c;
        n/=2;
        count++;
    }
    cout << "Bianry for " << n << "is: " << res << endl;
    if(n<MAX) dp[n-1]=res%MOD;
    return res%MOD;
}
int main()
{
    ll t,n,sum;
    cin>>t;
    cout << "Tests " << t << endl;
    ll dp[MAX]={0};
    while(t--){
        cin>>n;
        sum=0;
        for(int i=1;i<=n;i++){
            sum+=decToBin(i,dp);
            cout << sum << endl;
            sum=sum%MOD;
        }
        cout << sum << endl;
    }
    return 0;
}